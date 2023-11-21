package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public Monster(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth() - 50); // 如果未成功防御，减少80点生命值
		}
	}

	public boolean successfulDefense() {
		Random random = new Random();
		return random.nextBoolean(); // 以50%的概率返回true或false
	}

	@Override
	public char getSymbol() {
		return '%';
	}

	public String decideMove() {
		Random random = new Random();
		int move = random.nextInt(4); // 生成0到3之间的随机整数
		switch (move) {
			case 0:
				return "up";
			case 1:
				return "down";
			case 2:
				return "left";
			case 3:
				return "right";
			default:
				return "up"; // 默认返回“up”
		}
	}

	public String getName() {
		return super.getName();
	}
}
