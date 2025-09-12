import java.util.ArrayList;
import java.util.Scanner;

// Excepción personalizada para datos inválidos
class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para precio inferior
class PrecioInferiorException extends Exception {
    public PrecioInferiorException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para contrato inválido
class ContratoInvalidoException extends Exception {
    public ContratoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para pago inválido
class PagoInvalidoException extends Exception {
    public PagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Clase Propiedad
class Propiedad {
    private String direccion;
    private double precio;
    private double tamano;
    
    public Propiedad(String direccion, double precio, double tamano) throws DatosInvalidosException {
        this.direccion = direccion;
        
        // Validar que el precio sea positivo
        if (precio <= 0) {
            throw new DatosInvalidosException("El precio debe ser un valor positivo");
        }
        this.precio = precio;
        
        // Validar que el tamaño sea positivo
        if (tamano <= 0) {
            throw new DatosInvalidosException("El tamaño debe ser un valor positivo");
        }
        this.tamano = tamano;
    }
    
    // Getters y setters
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) throws DatosInvalidosException {
        if (precio <= 0) {
            throw new DatosInvalidosException("El precio debe ser un valor positivo");
        }
        this.precio = precio;
    }
    
    public double getTamano() {
        return tamano;
    }
    
    public void setTamano(double tamano) throws DatosInvalidosException {
        if (tamano <= 0) {
            throw new DatosInvalidosException("El tamaño debe ser un valor positivo");
        }
        this.tamano = tamano;
    }
    
    @Override
    public String toString() {
        return "Propiedad: " + direccion + ", Precio: $" + precio + ", Tamaño: " + tamano + " m²";
    }
}

// Clase TransaccionInmobiliaria
class TransaccionInmobiliaria {
    private static int contadorId = 1;
    private int id;
    private Propiedad propiedad;
    private double precioTransaccion;
    
    public TransaccionInmobiliaria(Propiedad propiedad, double precioTransaccion) throws PrecioInferiorException {
        this.id = contadorId++;
        this.propiedad = propiedad;
        
        // Validar que el precio de transacción no sea inferior al precio de la propiedad
        if (precioTransaccion < propiedad.getPrecio()) {
            throw new PrecioInferiorException("El precio de transacción (" + precioTransaccion + 
                                            ") no puede ser inferior al precio de la propiedad (" + 
                                            propiedad.getPrecio() + ")");
        }
        this.precioTransaccion = precioTransaccion;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public Propiedad getPropiedad() {
        return propiedad;
    }
    
    public double getPrecioTransaccion() {
        return precioTransaccion;
    }
    
    @Override
    public String toString() {
        return "Transacción #" + id + " - " + propiedad + ", Precio de Transacción: $" + precioTransaccion;
    }
}

// Clase ContratoAlquiler
class ContratoAlquiler {
    private static int contadorId = 1;
    private int id;
    private Propiedad propiedad;
    private int duracionMeses;
    private double montoAlquiler;
    
    public ContratoAlquiler(Propiedad propiedad) {
        this.id = contadorId++;
        this.propiedad = propiedad;
    }
    
    // Establecer la duración del contrato
    public void setDuracionMeses(int duracionMeses) throws ContratoInvalidoException {
        if (duracionMeses <= 0) {
            throw new ContratoInvalidoException("La duración del contrato debe ser un valor positivo");
        }
        this.duracionMeses = duracionMeses;
    }
    
    // Establecer el monto del alquiler
    public void setMontoAlquiler(double montoAlquiler) throws ContratoInvalidoException {
        if (montoAlquiler <= 0) {
            throw new ContratoInvalidoException("El monto del alquiler debe ser un valor positivo");
        }
        this.montoAlquiler = montoAlquiler;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public Propiedad getPropiedad() {
        return propiedad;
    }
    
    public int getDuracionMeses() {
        return duracionMeses;
    }
    
    public double getMontoAlquiler() {
        return montoAlquiler;
    }
    
    @Override
    public String toString() {
        return "Contrato de Alquiler #" + id + " - " + propiedad + 
               ", Duración: " + duracionMeses + " meses, Monto Mensual: $" + montoAlquiler;
    }
}

// Clase Pago
class Pago {
    private String fecha; // Formato: DD/MM/AAAA
    private double monto;
    
    public Pago(String fecha, double monto) throws PagoInvalidoException {
        // Validar formato de fecha (sin usar librerías externas)
        if (!validarFormatoFecha(fecha)) {
            throw new PagoInvalidoException("Formato de fecha inválido. Use el formato DD/MM/AAAA");
        }
        
        // Validar que la fecha no sea futura
        if (esFechaFutura(fecha)) {
            throw new PagoInvalidoException("No se puede registrar un pago con fecha futura");
        }
        
        // Validar que el monto sea positivo
        if (monto <= 0) {
            throw new PagoInvalidoException("El monto del pago debe ser un valor positivo");
        }
        
        this.fecha = fecha;
        this.monto = monto;
    }
    
    // Método para validar el formato de fecha (DD/MM/AAAA)
    private boolean validarFormatoFecha(String fecha) {
        // Verificar longitud
        if (fecha.length() != 10) {
            return false;
        }
        
        // Verificar separadores
        if (fecha.charAt(2) != '/' || fecha.charAt(5) != '/') {
            return false;
        }
        
        // Verificar que los demás caracteres sean dígitos
        for (int i = 0; i < fecha.length(); i++) {
            if (i != 2 && i != 5) {
                char c = fecha.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
        }
        
        // Extraer día, mes y año
        int dia = Integer.parseInt(fecha.substring(0, 2));
        int mes = Integer.parseInt(fecha.substring(3, 5));
        int anio = Integer.parseInt(fecha.substring(6, 10));
        
        // Validar rangos (simplificado)
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31 || anio < 2000 || anio > 2100) {
            return false;
        }
        
        return true;
    }
    
    // Método para verificar si una fecha es futura (simplificado)
    private boolean esFechaFutura(String fecha) {
        // Este es un método simplificado que asume que todas las fechas son pasadas
        // En una implementación real, se compararía con la fecha actual
        // Para este ejemplo, consideraremos que cualquier fecha del 2024 en adelante es futura
        int anio = Integer.parseInt(fecha.substring(6, 10));
        return anio > 2023;
    }
    
    // Getters
    public String getFecha() {
        return fecha;
    }
    
    public double getMonto() {
        return monto;
    }
    
    @Override
    public String toString() {
        return "Pago: Fecha: " + fecha + ", Monto: $" + monto;
    }
}

// Clase HistorialDePagos
class HistorialDePagos {
    private ArrayList<Pago> pagos;
    
    public HistorialDePagos() {
        pagos = new ArrayList<>();
    }
    
    // Registrar un pago
    public void registrarPago(Pago pago) {
        pagos.add(pago);
        System.out.println("Pago registrado: " + pago);
    }
    
    // Listar todos los pagos
    public void listarPagos() {
        if (pagos.isEmpty()) {
            System.out.println("No hay pagos registrados");
            return;
        }
        
        System.out.println("\n--- HISTORIAL DE PAGOS ---");
        for (int i = 0; i < pagos.size(); i++) {
            System.out.println((i+1) + ". " + pagos.get(i));
        }
    }
    
    // Calcular el total de pagos
    public double calcularTotalPagos() {
        double total = 0;
        for (Pago pago : pagos) {
            total += pago.getMonto();
        }
        return total;
    }
}

// Clase principal para probar el sistema
public class SistemaInmobiliario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Propiedad> propiedades = new ArrayList<>();
        ArrayList<TransaccionInmobiliaria> transacciones = new ArrayList<>();
        ArrayList<ContratoAlquiler> contratos = new ArrayList<>();
        HistorialDePagos historialPagos = new HistorialDePagos();
        
        int opcion;
        
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN INMOBILIARIA ===");
            System.out.println("1. Registrar propiedad");
            System.out.println("2. Listar propiedades");
            System.out.println("3. Registrar transacción de compra/venta");
            System.out.println("4. Listar transacciones");
            System.out.println("5. Crear contrato de alquiler");
            System.out.println("6. Listar contratos de alquiler");
            System.out.println("7. Registrar pago");
            System.out.println("8. Ver historial de pagos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese dirección de la propiedad: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese precio de la propiedad: ");
                        double precio = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese tamaño de la propiedad (m²): ");
                        double tamano = Double.parseDouble(scanner.nextLine());
                        
                        try {
                            Propiedad nuevaPropiedad = new Propiedad(direccion, precio, tamano);
                            propiedades.add(nuevaPropiedad);
                            System.out.println("Propiedad registrada con éxito: " + nuevaPropiedad);
                        } catch (DatosInvalidosException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 2:
                        if (propiedades.isEmpty()) {
                            System.out.println("No hay propiedades registradas");
                        } else {
                            System.out.println("\n--- PROPIEDADES REGISTRADAS ---");
                            for (int i = 0; i < propiedades.size(); i++) {
                                System.out.println((i+1) + ". " + propiedades.get(i));
                            }
                        }
                        break;
                        
                    case 3:
                        if (propiedades.isEmpty()) {
                            System.out.println("Primero debe registrar al menos una propiedad");
                            break;
                        }
                        
                        System.out.println("Seleccione una propiedad:");
                        for (int i = 0; i < propiedades.size(); i++) {
                            System.out.println((i+1) + ". " + propiedades.get(i));
                        }
                        
                        System.out.print("Ingrese el número de propiedad: ");
                        int indicePropiedad = Integer.parseInt(scanner.nextLine()) - 1;
                        
                        if (indicePropiedad < 0 || indicePropiedad >= propiedades.size()) {
                            System.out.println("Número de propiedad inválido");
                            break;
                        }
                        
                        Propiedad propiedadSeleccionada = propiedades.get(indicePropiedad);
                        System.out.print("Ingrese el precio de transacción: ");
                        double precioTransaccion = Double.parseDouble(scanner.nextLine());
                        
                        try {
                            TransaccionInmobiliaria transaccion = new TransaccionInmobiliaria(propiedadSeleccionada, precioTransaccion);
                            transacciones.add(transaccion);
                            System.out.println("Transacción registrada con éxito: " + transaccion);
                        } catch (PrecioInferiorException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 4:
                        if (transacciones.isEmpty()) {
                            System.out.println("No hay transacciones registradas");
                        } else {
                            System.out.println("\n--- TRANSACCIONES REGISTRADAS ---");
                            for (int i = 0; i < transacciones.size(); i++) {
                                System.out.println((i+1) + ". " + transacciones.get(i));
                            }
                        }
                        break;
                        
                    case 5:
                        if (propiedades.isEmpty()) {
                            System.out.println("Primero debe registrar al menos una propiedad");
                            break;
                        }
                        
                        System.out.println("Seleccione una propiedad para alquilar:");
                        for (int i = 0; i < propiedades.size(); i++) {
                            System.out.println((i+1) + ". " + propiedades.get(i));
                        }
                        
                        System.out.print("Ingrese el número de propiedad: ");
                        int indicePropiedadAlquiler = Integer.parseInt(scanner.nextLine()) - 1;
                        
                        if (indicePropiedadAlquiler < 0 || indicePropiedadAlquiler >= propiedades.size()) {
                            System.out.println("Número de propiedad inválido");
                            break;
                        }
                        
                        Propiedad propiedadAlquiler = propiedades.get(indicePropiedadAlquiler);
                        ContratoAlquiler contrato = new ContratoAlquiler(propiedadAlquiler);
                        
                        try {
                            System.out.print("Ingrese la duración del contrato (meses): ");
                            int duracion = Integer.parseInt(scanner.nextLine());
                            contrato.setDuracionMeses(duracion);
                            
                            System.out.print("Ingrese el monto mensual de alquiler: ");
                            double monto = Double.parseDouble(scanner.nextLine());
                            contrato.setMontoAlquiler(monto);
                            
                            contratos.add(contrato);
                            System.out.println("Contrato de alquiler creado con éxito: " + contrato);
                        } catch (ContratoInvalidoException | NumberFormatException e) {
                            System.out.println("Error: " + (e instanceof NumberFormatException ? "Formato inválido" : e.getMessage()));
                        }
                        break;
                        
                    case 6:
                        if (contratos.isEmpty()) {
                            System.out.println("No hay contratos de alquiler registrados");
                        } else {
                            System.out.println("\n--- CONTRATOS DE ALQUILER ---");
                            for (int i = 0; i < contratos.size(); i++) {
                                System.out.println((i+1) + ". " + contratos.get(i));
                            }
                        }
                        break;
                        
                    case 7:
                        System.out.print("Ingrese la fecha del pago (DD/MM/AAAA): ");
                        String fechaPago = scanner.nextLine();
                        System.out.print("Ingrese el monto del pago: ");
                        double montoPago = Double.parseDouble(scanner.nextLine());
                        
                        try {
                            Pago nuevoPago = new Pago(fechaPago, montoPago);
                            historialPagos.registrarPago(nuevoPago);
                        } catch (PagoInvalidoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 8:
                        historialPagos.listarPagos();
                        System.out.println("Total pagado: $" + historialPagos.calcularTotalPagos());
                        break;
                        
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido");
                opcion = -1;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = -1;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}
