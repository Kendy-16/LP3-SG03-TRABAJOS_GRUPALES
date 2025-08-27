public class Arquero extends PersonajeBase {
    public Arquero(String nombre) { super(nombre); }

    @Override
    public void atacar(PersonajeBase enemigo) {
    	if (!puedeAtacar(enemigo)) return;
        System.out.println(getNombre() + " dispara una flecha a " + enemigo.getNombre());
        enemigo.recibirDanio(12);
    }

    @Override
    public void usarHabilidad(PersonajeBase objetivo) {
    	if (!puedeAtacar(objetivo)) return;
        System.out.println(getNombre() + " usa Flecha Explosiva sobre " + objetivo.getNombre());
        objetivo.recibirDanio(20);
    }
}
