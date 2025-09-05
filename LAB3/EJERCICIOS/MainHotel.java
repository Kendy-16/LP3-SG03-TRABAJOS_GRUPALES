import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainHotel {
    public static void main(String[] args) {

        PoliticaCancelacion politica = new PoliticaCancelacionFlexible();
    	
    	
    	HabitacionDoble habitacionDoble1 = new HabitacionDoble(501, "Doble", 120.0, 50);
    	HabitacionDoble habitacionDoble2 = new HabitacionDoble(502, "Doble", 120.0, 50);
    	
    	HabitacionIndividual habitacionIndividual1 = new HabitacionIndividual(210, "Individual", 60.0);
    	HabitacionIndividual habitacionIndividual2 = new HabitacionIndividual(211, "Individual", 60.0);

    	Suite suite1 = new Suite(601, "Suite", 300.0, 150);
    	Suite suite2 = new Suite(602, "Suite Presidencial", 900.0, 550);
    	
    	Huesped huesped1 = new Huesped("Vanesa Arce", 970810306, 71451095);
    	Huesped huesped2 = new Huesped("Kelly Ramos", 967123215, 67451092);

    	
    	
    	Reserva reserva1 = new Reserva(123, "Vanesa Arce", habitacionDoble1, huesped1, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 9, 4));
    	Reserva reserva2 = new Reserva(123, "Kelly Ramos", habitacionDoble2, huesped2, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 9, 4));
    	
        
        System.out.println("Precio base: $" + reserva1.toString());
        System.out.println("Precio base: $" + reserva2.toString());

        reserva1.setFechaCheckIn(LocalDateTime.of(2025, 9, 1, 14, 0));
        System.out.println("Check-In: " + reserva1.getFechaCheckIn());

        reserva2.setFechaCheckIn(LocalDateTime.of(2025, 8, 31, 13, 30));
        System.out.println("Check-In: " + reserva2.getFechaCheckIn());



    }
}
