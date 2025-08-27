public class Guerrero extends PersonajeBase {
    public Guerrero(String nombre) { super(nombre); }
    
    @Override
    public void atacar(PersonajeBase enemigo) {
    	if (!puedeAtacar(enemigo)) return;
        System.out.println(getNombre() + " ataca con espada a " + enemigo.getNombre());
        enemigo.recibirDanio(15);
    }

    @Override
    public void usarHabilidad(PersonajeBase objetivo) {
    	if (!puedeAtacar(objetivo)) return;
        System.out.println(getNombre() + " usa Golpe Poderoso sobre " + objetivo.getNombre());
        objetivo.recibirDanio(25);
    }
}
