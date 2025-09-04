class Combatiente {
    String name;
    int hp;
    int level;
    Weapon weapon;
    double fireResistance = 1.0; // <1 = resiste, >1 = débil
    double iceResistance = 1.0;

    public Combatiente(String name, int hp, int level, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.weapon = weapon;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " recibe " + damage + " de daño. Vida: " + hp);
    }

    // Devuelve resistencia según elemento del ataque
    public double getResistance(String element) {
        if (element.equals("FIRE")) return fireResistance;
        if (element.equals("ICE")) return iceResistance;
        return 1.0;
    }
}
