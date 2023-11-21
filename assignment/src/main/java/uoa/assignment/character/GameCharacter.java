package uoa.assignment.character;

public abstract class GameCharacter {

	private String name ="";
	private int health = 100; // 初始化生命值为100

	public int row;
	public int column;

	public GameCharacter (String name) {
		this.name = name; // 设置名称
	}

	public abstract void hurtCharacter (GameCharacter character);

	public abstract boolean successfulDefense ();

	public String sayName() {
		return name; // 返回名称
	}

	public int getHealth() {
		return health; // 返回生命值
	}

	public void setHealth(int health) {
		this.health = health; // 设置生命值
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	public abstract char getSymbol();

	public String getName() {
		return name;
	}
}

