package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			System.out.println("!!HIT!! " + this.sayName() + " successfully attacked " + character.sayName());
			if (character.getHealth() <= 0) {
				System.out.println("Character already dead");
			} else {
				character.setHealth(Math.max(0, character.getHealth() - 50));
			}
		} else {
			System.out.println("!!MISS!! " + character.sayName() + " successfully defended attack from " + this.sayName());
		}
	}


	public boolean successfulDefense() {
		Random random = new Random();
		int randomNumber = random.nextInt(10) + 1;
		return (randomNumber <= 3);
	}

}

