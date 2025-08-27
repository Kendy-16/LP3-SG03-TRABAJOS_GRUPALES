package act1;

public class Coche {
    // Atributos
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private double precio;
    private boolean encendido;

    // Constructor 1: Parametrizado (marca, modelo, año, precio)
    public Coche(String marca, String modelo, int anioFabricacion, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
        this.encendido = false;
    }

    // Constructor 2: Solo marca y modelo (ejemplo de sobrecarga)
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = 2023;
        this.precio = 0.0;
        this.encendido = false;
    }

    // Constructor 3: Por defecto / Default
    public Coche() {
        this.marca = "Sin marca";
        this.modelo = "Sin modelo";
        this.anioFabricacion = 2000;
        this.precio = 10000.0;
        this.encendido = false;
    }

    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println(marca + " " + modelo + " está encendido.");
        } else {
            System.out.println("El coche ya estaba encendido.");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println(marca + " " + modelo + " se apagó.");
        } else {
            System.out.println("El coche ya estaba apagado.");
        }
    }

    public void acelerar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está acelerando 🚗💨");
        } else {
            System.out.println("Primero encienda el coche.");
        }
    }

    public void frenar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " frenó.");
        } else {
            System.out.println("El coche está apagado, no puede frenar.");
        }
    }

    // Método aplicarDescuento
    public void aplicarDescuento() {
        if (anioFabricacion < 2010) {
            double descuento = precio * 0.10; // 10% de descuento
            precio -= descuento;
            System.out.println("Se aplicó un descuento de 10%. Nuevo precio: $" + precio);
        } else {
            System.out.println("No se aplicó descuento, el modelo no es antiguo.");
        }
    }

    // Getters y Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnioFabricacion() { return anioFabricacion; }
    public void setAnioFabricacion(int anioFabricacion) { this.anioFabricacion = anioFabricacion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
