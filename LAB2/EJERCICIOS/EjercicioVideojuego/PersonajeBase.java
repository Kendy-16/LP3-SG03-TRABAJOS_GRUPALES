import java.util.Vector;

public abstract class PersonajeBase {
    // Variables de instancia
    private String nombre;
    private int salud;
    private int nivel;
    private int experiencia;

    // Variable de clase (static)
    private static int contadorPersonajes = 0;

    // Constantes (final)
    public static final int MAX_SALUD = 100;
    public static final int MAX_NIVEL = 50;

    // Relaciones
    protected Vector<Habilidad> habilidades; // composición
    protected Inventario inventario;         // agregación

    // Constructor
    public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.salud = MAX_SALUD;
        this.nivel = 1;
        this.experiencia = 0;
        this.habilidades = new Vector<>();
        this.inventario = new Inventario();
        contadorPersonajes++;
    }

    // Métodos abstractos
    public abstract void atacar(PersonajeBase enemigo);
    public abstract void usarHabilidad(PersonajeBase objetivo);

    // Métodos con distintos modificadores
    public void mostrarInfo() { // public
        System.out.println("[" + getClass().getSimpleName() + "] "
                + nombre + " | Salud: " + salud + " | Nivel: " + nivel + " | EXP: "+ experiencia);
    }

    public boolean puedeAtacar(PersonajeBase enemigo) {
        if (this.estaMuerto()) {
            System.out.println(getNombre() + " está muerto y no puede atacar.");
            return false;
        }
        if (enemigo.estaMuerto()) {
            System.out.println(enemigo.getNombre() + " ya está muerto, no puede recibir ataques.");
            return false;
        }
        return true;
    }
    
    protected void recibirDanio(int danio) { // protected
        salud -= danio;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " recibió " + danio + " de daño. Salud: " + salud);
    }
    
    public boolean estaMuerto() {
        return salud <= 0;
    }

    int getNivel() { // default
        return nivel;
    }
    
    public void revisarNivel() {
        int expNecesaria = nivel * 50; // ejemplo: 50 EXP * nivel actual
        if (experiencia >= expNecesaria && nivel < MAX_NIVEL) {
            experiencia -= expNecesaria; // gasta esa EXP
            subirNivel();                // ya existe como private
        }
    }
    
    public void ganarExp(int cantidad) {
        if (estaMuerto()) return;
        experiencia += cantidad;
        System.out.println(getNombre() + " ganó " + cantidad + " EXP. Total: " + experiencia);
        revisarNivel();
    }
    
    private void subirNivel() { // private
        if (nivel < MAX_NIVEL) {
            nivel++;
            System.out.println(nombre + " subió a nivel " + nivel);
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public Inventario getInventario() { return inventario; }
    public static int getContadorPersonajes() { return contadorPersonajes; }

    // Método para probar
    public void ganarExperiencia() { subirNivel(); }
}import java.util.Vector;

public abstract class PersonajeBase {
    // Variables de instancia
    private String nombre;
    private int salud;
    private int nivel;
    private int experiencia;

    // Variable de clase (static)
    private static int contadorPersonajes = 0;

    // Constantes (final)
    public static final int MAX_SALUD = 100;
    public static final int MAX_NIVEL = 50;

    // Relaciones
    protected Vector<Habilidad> habilidades; // composición
    protected Inventario inventario;         // agregación

    // Constructor
    public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.salud = MAX_SALUD;
        this.nivel = 1;
        this.experiencia = 0;
        this.habilidades = new Vector<>();
        this.inventario = new Inventario();
        contadorPersonajes++;
    }

    // Métodos abstractos
    public abstract void atacar(PersonajeBase enemigo);
    public abstract void usarHabilidad(PersonajeBase objetivo);

    // Métodos con distintos modificadores
    public void mostrarInfo() { // public
        System.out.println("[" + getClass().getSimpleName() + "] "
                + nombre + " | Salud: " + salud + " | Nivel: " + nivel + " | EXP: "+ experiencia);
    }

    public boolean puedeAtacar(PersonajeBase enemigo) {
        if (this.estaMuerto()) {
            System.out.println(getNombre() + " está muerto y no puede atacar.");
            return false;
        }
        if (enemigo.estaMuerto()) {
            System.out.println(enemigo.getNombre() + " ya está muerto, no puede recibir ataques.");
            return false;
        }
        return true;
    }
    
    protected void recibirDanio(int danio) { // protected
        salud -= danio;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " recibió " + danio + " de daño. Salud: " + salud);
    }
    
    public boolean estaMuerto() {
        return salud <= 0;
    }

    int getNivel() { // default
        return nivel;
    }
    
    public void revisarNivel() {
        int expNecesaria = nivel * 50; // ejemplo: 50 EXP * nivel actual
        if (experiencia >= expNecesaria && nivel < MAX_NIVEL) {
            experiencia -= expNecesaria; // gasta esa EXP
            subirNivel();                // ya existe como private
        }
    }
    
    public void ganarExp(int cantidad) {
        if (estaMuerto()) return;
        experiencia += cantidad;
        System.out.println(getNombre() + " ganó " + cantidad + " EXP. Total: " + experiencia);
        revisarNivel();
    }
    
    private void subirNivel() { // private
        if (nivel < MAX_NIVEL) {
            nivel++;
            System.out.println(nombre + " subió a nivel " + nivel);
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public Inventario getInventario() { return inventario; }
    public static int getContadorPersonajes() { return contadorPersonajes; }

    // Método para probar
    public void ganarExperiencia() { subirNivel(); }
}
