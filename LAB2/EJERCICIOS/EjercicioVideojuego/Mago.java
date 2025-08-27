public class Mago extends PersonajeBase {
    public Mago(String nombre) { super(nombre); }

    @Override
    public void atacar(PersonajeBase enemigo) {
    	if (!puedeAtacar(enemigo)) return;
        System.out.println(getNombre() + " lanza rayo mágico a " + enemigo.getNombre());
        enemigo.recibirDanio(10);
    }

    @Override
    public void usarHabilidad(PersonajeBase objetivo) {
    	if (!puedeAtacar(objetivo)) return;
        System.out.println(getNombre() + " usa Bola de Fuego sobre " + objetivo.getNombre());
        objetivo.recibirDanio(30);
    }
}
