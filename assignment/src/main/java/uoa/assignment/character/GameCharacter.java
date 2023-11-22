// 定义包路径
package uoa.assignment.character;

// 定义抽象类 GameCharacter
public abstract class GameCharacter {

	// 定义私有成员变量 name，初始化为空字符串
	private String name ="";

	// 定义私有成员变量 health，初始化为100
	private int health = 100; // 初始化生命值为100

	// 定义公共成员变量 row
	public int row;

	// 定义公共成员变量 column
	public int column;

	// 定义构造函数，接受一个字符串参数 name
	public GameCharacter (String name) {
		this.name = name; // 设置名称
	}

	// 定义抽象方法 hurtCharacter，无具体实现
	public abstract void hurtCharacter (GameCharacter character);

	// 定义抽象方法 successfulDefense，返回布尔值，无具体实现
	public abstract boolean successfulDefense ();

	// 定义方法 sayName，返回名称
	public String sayName() {
		return name; // 返回名称
	}

	// 定义方法 getHealth，返回生命值
	public int getHealth() {
		return health; // 返回生命值
	}

	// 定义方法 setHealth，接受一个整数参数 health，设置生命值
	public void setHealth(int health) {
		this.health = health; // 设置生命值
	}

	// 定义方法 getRow，返回行数
	public int getRow() {
		return row;
	}

	// 定义方法 setRow，接受一个整数参数 row，设置行数
	public void setRow(int row) {
		this.row = row;
	}

	// 定义方法 getColumn，返回列数
	public int getColumn() {
		return column;
	}

	// 定义方法 setColumn，接受一个整数参数 column，设置列数
	public void setColumn(int column) {
		this.column = column;
	}

	// 定义方法 getName，返回名称
	public String getName() {
		return name;
	}
}


