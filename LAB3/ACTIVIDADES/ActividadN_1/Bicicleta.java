public class Bicicleta extends Vehiculo {
    private int numRuedas;
    private String marca;

    public Bicicleta(int numRuedas, String marca) {
        this.numRuedas = numRuedas;
        this.marca = marca;
    }

    @Override
    public void acelerar() {
        System.out.println("La bicicleta " + marca + " está avanzando pedaleando.");
    }
}
