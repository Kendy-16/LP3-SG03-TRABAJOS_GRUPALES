import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainHotel {
    public static void main(String[] args) {


        System.out.println("=== SISTEMA DE RESERVAS HOTELERAS ===\n");
        
        // 1. Creación de habitaciones (individual, doble y suite)
        System.out.println("1. CREANDO HABITACIONES:");
        System.out.println("========================");
        
        HabitacionIndividual individual1 = new HabitacionIndividual(101, "Individual", 80.0);
        HabitacionIndividual individual2 = new HabitacionIndividual(102, "Individual", 80.0);
        
        HabitacionDoble doble1 = new HabitacionDoble(201, "Doble", 120.0, 30.0);
        HabitacionDoble doble2 = new HabitacionDoble(202, "Doble", 120.0, 30.0);
        
        Suite suite1 = new Suite(301, "Suite", 250.0, 100.0);
        Suite suitePresidencial = new Suite(401, "Suite Presidencial", 500.0, 200.0);
        
        System.out.println(individual1);
        System.out.println(doble1);
        System.out.println(suite1);
        System.out.println(suitePresidencial);
        System.out.println();

        // 2. Creación de los huespedes
        System.out.println("2. REGISTRANDO HUÉSPEDES:");
        System.out.println("========================");
        
        Huesped huesped1 = new Huesped("Juan Pérez", 987654321, 12345678);
        Huesped huesped2 = new Huesped("María García", 912345678, 87654321);
        Huesped huesped3 = new Huesped("Carlos López", 923456789, 11223344);
        
        System.out.println("Huésped 1: " + huesped1);
        System.out.println("Huésped 2: " + huesped2);
        System.out.println("Huésped 3: " + huesped3);
        System.out.println();

        // 3. Creacion de Reserva
        System.out.println("3. REALIZANDO RESERVAS:");
        System.out.println("=======================");
        
        Reserva reserva1 = new Reserva(1, "Juan Pérez", individual1, huesped1, 
                                      LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 20));
        
        Reserva reserva2 = new Reserva(2, "María García", doble1, huesped2, 
                                      LocalDate.of(2024, 12, 18), LocalDate.of(2024, 12, 25));
        
        Reserva reserva3 = new Reserva(3, "Carlos López", suite1, huesped3, 
                                      LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15));
        
        System.out.println("Reserva 1: " + reserva1);
        System.out.println("Reserva 2: " + reserva2);
        System.out.println("Reserva 3: " + reserva3);
        System.out.println();

        // 4. Probando la disponibilidad de la habitación
        System.out.println("4. VERIFICANDO DISPONIBILIDAD:");
        System.out.println("==============================");
        
        List<Reserva> todasReservas = new ArrayList<>();
        todasReservas.add(reserva1);
        todasReservas.add(reserva2);
        todasReservas.add(reserva3);
        
        GestorDisponibilidadHabitacion gestorDisp = new GestorDisponibilidadHabitacion(individual2, todasReservas);
        
        System.out.println("¿Habitación 102 disponible? " + gestorDisp.verificarDisponibilidad());
        System.out.println("¿Disponible del 20-12 al 22-12? " + 
            gestorDisp.estaDisponible(LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 22)));
        System.out.println();

        // 5. Llamar a los servicio a la habitacion (Limpieza, Comida, Lavanderia)
        System.out.println("5. SOLICITANDO SERVICIOS:");
        System.out.println("=========================");
        
        System.out.println("--- Servicios Individual ---");
        individual1.solicitarLimpieza();
        individual1.limpiezaCompletada();
        
        System.out.println("\n--- Servicios Doble ---");
        doble1.solicitarLimpieza();
        doble1.solicitarLavanderia();
        System.out.println("Costo lavandería (5kg): $" + doble1.calcularCostoLavanderia(5.0));
        
        System.out.println("\n--- Servicios Suite ---");
        suite1.solicitarLimpieza();
        suite1.solicitarLavanderia();
        suite1.soliciatComida();
        System.out.println("Costo comida (3 platos): $" + suite1.obtenerPrecioComida(3));
        System.out.println();

        // 6. Manejo del sistema de notificaciones
        System.out.println("6. NOTIFICACIONES:");
        System.out.println("==================");
        
        CanalNotificacion sms = new EnviarSMS();     //SMS (Polimorfismo)
        CanalNotificacion correo = new EnviarCorreo();    //Correo (Polimorfismo)
        
        NotificadorReserva notificadorSMS = new NotificadorReserva(sms);
        NotificadorReserva notificadorCorreo = new NotificadorReserva(correo);
        
        notificadorSMS.notificarConfirmacionReserva(reserva1);
        notificadorCorreo.notificarConfirmacionReserva(reserva2);
        System.out.println();

        // 7. Aplicacion las Politicas de Cancelacion
        System.out.println("7. POLÍTICAS DE CANCELACIÓN:");
        System.out.println("============================");
        
        PoliticaCancelacion politicaFlexible = new PoliticaCancelacionFlexible();
        
        // Simular check-in futuro
        reserva1.setFechaCheckIn(LocalDateTime.of(2024, 12, 15, 14, 0));
        
        System.out.println("¿Puede cancelar reserva 1? " + politicaFlexible.puedeCancelar(reserva1));
        System.out.println("Penalización: $" + politicaFlexible.calcularPenalizacion(reserva1));
        System.out.println();

        // 8. Sistemas de promociones (por temporada alta o cliente frecuente)
        System.out.println("8. APLICANDO PROMOCIONES:");
        System.out.println("========================");
        
        Promocion promoTemporadaAlta = new PromocionTemporadaAlta(15.0);
        Promocion promoClienteFrecuente = new PromocionClienteFrecuente(5, 50.0);
        
        System.out.println("Promo Temporada Alta: " + promoTemporadaAlta.getDescripcion());
        System.out.println("¿Aplicable a reserva 1? " + promoTemporadaAlta.esAplicable(reserva1));
        
        double precioOriginal = reserva1.calcularCosto();
        double precioConDescuento = promoTemporadaAlta.aplicarDescuento(precioOriginal);
        
        System.out.println("Precio original: $" + precioOriginal);
        System.out.println("Precio con descuento: $" + precioConDescuento);
        System.out.println();

        // 9. Cálculo de precio
        System.out.println("9. CÁLCULOS DE PRECIOS:");
        System.out.println("=======================");
        
        CalculadoraPrecio calculadoraBase = new CalculadoraPrecioBase();
        
        // Precio base
        double precioBase = calculadoraBase.calcularPrecio(
            individual1, 
            LocalDate.of(2024, 12, 15), 
            LocalDate.of(2024, 12, 20)
        );
        System.out.println("Precio base (5 noches): $" + precioBase);
        
        // Precio con promoción
        CalculadoraPrecio calculadoraConPromo = new CalculadoraPrecioConPromocion(
            calculadoraBase, 
            promoTemporadaAlta
        );
        
        double precioPromo = calculadoraConPromo.calcularPrecio(
            individual1,
            LocalDate.of(2024, 12, 15),
            LocalDate.of(2024, 12, 20)
        );
        System.out.println("Precio con promoción: $" + precioPromo);
        System.out.println();

        // 10. Prueba de cancelación
        System.out.println("10. PRUEBA DE CANCELACIÓN:");
        System.out.println("==========================");
        
        boolean cancelacionExitosa = reserva1.cancelarReserva(politicaFlexible);
        System.out.println("Cancelación exitosa: " + cancelacionExitosa);
        
        if (cancelacionExitosa) {
            notificadorSMS.notificarCancelacionReserva(reserva1);
        }
        System.out.println();

    }
}
