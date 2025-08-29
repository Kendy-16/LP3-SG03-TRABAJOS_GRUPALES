interface DamageCalculator{
	
	int calculateDamage(int level);
}

public abstract class Weapon implements DamageCalculator {
	
	protected int baseDamage;
	
	public Weapon(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public abstract int calculateDamage(int level);
}

class Espada extends Weapon{

	public Espada(int baseDamage) {
		super(baseDamage);
	}
	
	@Override
	public int calculateDamage(int level) {

		return getBaseDamage()  + (level * 5);
	}
}

class Arco extends Weapon{
	
	public Arco(int baseDamage) {
		super(baseDamage);
	}
	
	@Override
	public int calculateDamage(int level) {
		
		return getBaseDamage()  + (level * 4);
	}
}

class Hacha extends Weapon{
	
	public Hacha(int baseDamage) {
		super(baseDamage);
	}
	
	@Override
	public int calculateDamage(int level) {
		
		return getBaseDamage()  + (level * 6);
	}
}
