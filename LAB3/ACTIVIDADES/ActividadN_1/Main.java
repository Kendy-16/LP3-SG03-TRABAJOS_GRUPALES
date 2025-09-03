public class Main {
    public static void main(String[] args) {
        Vehiculo bicicleta = new Bicicleta(2, "Ty-6");
        Vehiculo carro = new Carro(false, "Toyota", 4);

        Vehiculo[] flota = {bicicleta, carro};
        for (Vehiculo v : flota) {
            v.acelerar();
            System.out.println("---");
        }
    }
}
