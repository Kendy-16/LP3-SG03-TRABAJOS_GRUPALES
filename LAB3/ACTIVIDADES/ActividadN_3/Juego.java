public class Juego {
	
	public static void main(String[] args) {
		
		Weapon sword = new Espada(50);
		Weapon bow = new Arco(30);
		Weapon axe = new Hacha(60);
		
		int swordDamage = sword.calculateDamage(10);
		int bowDamage = bow.calculateDamage(10);
		int axeDamage = axe.calculateDamage(10);
		
		System.out.println("Daño de espada: " + swordDamage);
		System.out.println("Daño de arco: " + bowDamage);
		System.out.println("Daño de hacha: " + axeDamage);
	}
}
