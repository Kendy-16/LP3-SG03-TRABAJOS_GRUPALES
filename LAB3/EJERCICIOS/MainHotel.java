import java.time.LocalDate;

public class MainHotel {
    public static void main(String[] args) {
        Habitacion h1 = new Habitacion(101, 150.0);

        Huesped juan = new Huesped("Juan Pérez", 12345678, 71461095);
        Huesped maria = new Huesped("María López", 87654321, 71461092);

        Reserva r1 = new Reserva(h1, juan, LocalDate.of(2025, 9, 2), LocalDate.of(2025, 9, 5));
        Reserva r2 = new Reserva(h1, maria, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 13));

        h1.agregarReserva(r1);
        h1.agregarReserva(r2);

        System.out.println(h1);
        for (Reserva r : h1.getReservas()) {
            System.out.println(r);
        }
    }
}
