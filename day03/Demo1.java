package day03;

interface Assaultable {
	abstract void attack();
}

interface Mobile {
	abstract void move();
}

abstract class Weapon implements Assaultable, Mobile {
};

class Tank extends Weapon {
	public void attack() {
		System.out.println("Tank attacks");
	}

	public void move() {
		System.out.println("Tank moves");
	}
}

class Flighter extends Weapon {
	public void attack() {
		System.out.println("Flighter attacks");
	}
	public void move() {
		System.out.println("Flighter moves");
	}
}

class WarShip extends Weapon {
	public void attack() {
		System.out.println("WarShip attacks");
	}

	public void move() {
		System.out.println("WarShip moves");
	}
}

class Army {
	Weapon w[];
	static int size = 0;

	public Army(int i) {
		w = new Weapon[i];
	}

	void addWeapon(Weapon wa) {
		if (size <= w.length)
			w[size++] = wa;
		else
			System.out.println("超过最大武器数量");

	}

	void moveAll() {
		for (int i = 0; i < size; i++) {
			w[i].move();
		}
	}

	void attackAll() {
		for (int i = 0; i < size; i++) {
			w[i].attack();
		}
	}
}

public class Demo1 {
	public static void main(String[] args) {
		Army army = new Army(6);
		army.addWeapon(new WarShip());
		army.addWeapon(new WarShip());
		army.addWeapon(new Tank());
		army.addWeapon(new Tank());
		army.addWeapon(new Flighter());
		army.attackAll();
		army.moveAll();

	}

}
