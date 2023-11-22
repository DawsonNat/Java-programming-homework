package uoa.assignment.character;

import java.util.Random;

// 定义 Player 类，继承自 GameCharacter 类
public class Player extends GameCharacter{

	// 定义 Player 类的构造函数，接受一个字符串参数 name
	public Player(String name) {
		super(name); // 调用父类的构造函数，传入 name 参数
	}

	// 定义方法 hurtCharacter，接受一个 GameCharacter 类型的参数 character
	public void hurtCharacter(GameCharacter character) {
		// 如果 character 的 successfulDefense 方法返回 false
		if (!character.successfulDefense()) {
			// 输出成功攻击信息
			System.out.println("!!HIT!! " + this.sayName() + " successfully attacked " + character.sayName());
			// 如果 character 的生命值小于等于 0
			if (character.getHealth() <= 0) {
				// 输出角色已死亡信息
				System.out.println("Character already dead");
			} else {
				// 减少 character 的生命值，最小为 0
				character.setHealth(Math.max(0, character.getHealth() - 50));
			}
		} else {
			// 输出成功防御信息
			System.out.println("!!MISS!! " + character.sayName() + " successfully defended attack from " + this.sayName());
		}
	}

	// 定义方法 successfulDefense，返回布尔值
	public boolean successfulDefense() {
		// 创建 Random 对象
		Random random = new Random();
		// 生成 1 到 10 之间的随机整数
		int randomNumber = random.nextInt(10) + 1;
		// 返回随机数是否小于等于 3
		return (randomNumber <= 3);
	}

}