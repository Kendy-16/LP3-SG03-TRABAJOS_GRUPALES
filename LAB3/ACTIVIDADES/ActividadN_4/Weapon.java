interface DamageCalculator {
    int calculateDamage(int level, double resistance);
}

abstract class Weapon implements DamageCalculator {
    protected String name;
    protected int baseDamage;
    protected String element;         // "NONE", "FIRE", "ICE", etc.
    protected double critChance;      // 0.0 a 1.0
    protected double critMultiplier;  // ej: 1.5 = +50%
    protected int levelFactor;        // daño extra por nivel

    public Weapon(String name, int baseDamage, String element,
                  double critChance, double critMultiplier, int levelFactor) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.element = element;
        this.critChance = critChance;
        this.critMultiplier = critMultiplier;
        this.levelFactor = levelFactor;
    }

    @Override
    public int calculateDamage(int level, double resistance) {
        // daño base + nivel
        double damage = baseDamage + level * levelFactor;
        // random factor (80% a 120%)
        double factorRandom = 0.8 + Math.random() * 0.4;
        damage = damage * factorRandom;
        // aplicar resistencia
        damage = damage * resistance;
        if (Math.random() < critChance) {
            damage = damage * critMultiplier;
            System.out.println("¡Golpe crítico!");
        }

        return (int)Math.round(damage);
    }

    public String getName() { return name; }
    public String getElement() { return element; }
}

class Espada extends Weapon {
    public Espada(String name, int baseDamage, String element) {
        super(name, baseDamage, element, 0.20, 1.5, 5); // 20% crit, x1.5, factor 5
    }
}

class Hacha extends Weapon {
    public Hacha(String name, int baseDamage, String element) {
        super(name, baseDamage, element, 0.15, 1.7, 6); // 15% crit, x1.7, factor 6
    }
}

class Arco extends Weapon {
    public Arco(String name, int baseDamage, String element) {
        super(name, baseDamage, element, 0.25, 1.4, 4); // 25% crit, x1.4, factor 4
    }
}
