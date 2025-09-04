public class Juego {
    public static void main(String[] args) {
        // Crear las 3 armas
        Weapon espadaFuego = new Espada("Espada de Fuego", 40, "FIRE");
        Weapon hachaNormal = new Hacha("Hacha Pesada", 60, "NONE");
        Weapon arcoHelado  = new Arco("Arco Helado", 35, "ICE");

        // Probar las 3 armas en combates separados
        System.out.println("=== COMBATE CON ESPADA ===");
        simularCombate(espadaFuego, hachaNormal);
        System.out.println("==========================");

        System.out.println("\n=== COMBATE CON HACHA ===");
        simularCombate(hachaNormal, hachaNormal);
        System.out.println("==========================");

        System.out.println("\n=== COMBATE CON ARCO ===");
        simularCombate(arcoHelado, hachaNormal);
        System.out.println("==========================");
    }

    public static void simularCombate(Weapon armaJugador, Weapon armaGolem) {
        // crear jugador y enemigo
        Combatiente jugador = new Combatiente("Heroe", 200, 10, armaJugador);
        Combatiente enemigo = new Combatiente("Golem", 250, 8, armaGolem);

        // resistencias del Gólem
        enemigo.fireResistance = 0.7;
        enemigo.iceResistance = 1.3;

        int ronda = 1;
        while (jugador.isAlive() && enemigo.isAlive()) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            // jugador ataca
            double resEnemigo = enemigo.getResistance(jugador.weapon.getElement());
            int dañoJugador = jugador.weapon.calculateDamage(jugador.level, resEnemigo);
            System.out.println(jugador.name + " ataca con " + jugador.weapon.getName());
            enemigo.receiveDamage(dañoJugador);

            if (!enemigo.isAlive()) break;

            // enemigo ataca
            double resJugador = jugador.getResistance(enemigo.weapon.getElement());
            int dañoEnemigo = enemigo.weapon.calculateDamage(enemigo.level, resJugador);
            System.out.println(enemigo.name + " ataca con " + enemigo.weapon.getName());
            jugador.receiveDamage(dañoEnemigo);
            ronda++;
        }

        // resultado
        if (jugador.isAlive()) {
            System.out.println("\n" + jugador.name + " gana la batalla!");
        } else {
            System.out.println("\n" + enemigo.name + " gana la batalla!");
        }
    }
}
