// 定义包路径
package uoa.assignment.character;

// 导入 Random 类
import java.util.Random;

// 定义 Monster 类，继承自 GameCharacter 类
public class Monster extends GameCharacter {

	// 定义 Monster 类的构造函数，接受一个字符串参数 name
	public Monster(String name) {
		super(name); // 调用父类的构造函数，传入 name 参数
	}

	// 定义方法 hurtCharacter，接受一个 GameCharacter 类型的参数 character
	public void hurtCharacter(GameCharacter character) {
		// 如果 character 的 successfulDefense 方法返回 false
		if (!character.successfulDefense()) {
			// 减少 character 的生命值 20 点
			character.setHealth(character.getHealth() - 20); // 如果未成功防御，减少20点生命值
		}
	}

	// 定义方法 successfulDefense，返回布尔值
	public boolean successfulDefense() {
		// 创建 Random 对象
		Random random = new Random();
		// 以50%的概率返回 true 或 false
		return random.nextBoolean(); // 以50%的概率返回true或false
	}

	// 定义方法 decideMove，返回字符串类型
	public String decideMove() {
		// 创建 Random 对象
		Random random = new Random();
		// 生成 0 到 3 之间的随机整数
		int move = random.nextInt(4); // 生成0到3之间的随机整数
		// 根据随机数返回移动方向
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

	// 重写父类的 getName 方法，返回父类的名称
	public String getName() {
		return super.getName();
	}
}