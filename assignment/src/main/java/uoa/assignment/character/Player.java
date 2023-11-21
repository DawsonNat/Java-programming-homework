package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter {

	public Player(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth() - 50); // 如果未成功防御，减少20点生命值
		}
	}

	public boolean successfulDefense() {
		Random random = new Random();
		return random.nextInt(10) < 3; // 30%的概率返回true
	}

	@Override
	public char getSymbol() {
		return '*';
	}


}
