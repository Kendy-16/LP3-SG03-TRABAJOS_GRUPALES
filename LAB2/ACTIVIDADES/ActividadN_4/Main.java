public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona(1, "Carlos", "Ramírez");
        Persona p2 = new Persona(2, "Ana", "Torres");

        // Modificar saldo de las cuentas
        p1.getCuenta().setSaldo(500.0);
        p2.getCuenta().setSaldo(1500.0);

        // Mostrar información
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
