public class Carro extends Vehiculo {
    private boolean encendido;
    private String nombre;
    private int numPuertas;

    public Carro(boolean encendido, String nombre, int numPuertas) {
        this.encendido = encendido;
        this.nombre = nombre;
        this.numPuertas = numPuertas;
    }

    public boolean encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("Se ha encendido el carro: " + nombre);
        }
        return encendido;
    }

    @Override
    public void acelerar() {
        if (!encendido) {
            System.out.println("El carro " + nombre + " estaba apagado. Intentando encender...");
            encender();
        }
        System.out.println("El carro " + nombre + " está acelerando usando el motor.");
    }
}
