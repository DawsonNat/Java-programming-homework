package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

    public String[][] layout; // 游戏地图的布局
    public GameCharacter[] characters; // 游戏中的角色数组

    // 构造函数，初始化地图和角色
    public Map(int height, int width) {
        layout = new String[height][width]; // 初始化地图布局
        characters = new GameCharacter[4]; // 初始化角色数组
        initialiseArray(); // 初始化地图布局
        createCharacters(); // 创建角色
    }

    // 初始化地图布局的方法
    private void initialiseArray() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = "."; // 将地图布局填充为"."
            }
        }
    }

    // 创建角色的方法
    private void createCharacters() {
        // 创建玩家角色并设置其位置
        characters[0] = new Player("Player");
        characters[0].setRow(layout.length - 1);
        characters[0].setColumn(layout[0].length - 1);
        layout[layout.length - 1][layout[0].length - 1] = "*";

        // 创建怪物角色并设置其位置
        characters[1] = new Monster("Monster1");
        characters[1].setRow(0);
        characters[1].setColumn(layout[0].length - 1);
        layout[0][layout[0].length - 1] = "%";

        characters[2] = new Monster("Monster2");
        characters[2].setRow(layout.length - 1);
        characters[2].setColumn(0);
        layout[layout.length - 1][0] = "%";

        characters[3] = new Monster("Monster3");
        characters[3].setRow(0);
        characters[3].setColumn(0);
        layout[0][0] = "%";
    }

    // 打印地图布局的方法
    public void printLayout() {
        for (String[] row : layout) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    // 获取玩家角色的方法
    public Player getPlayer() {
        for (GameCharacter character : characters) {
            if (character instanceof Player) {
                return (Player) character;
            }
        }
        return null; // 如果没有找到玩家角色，返回null
    }

    // 获取怪物角色的方法
    public Monster[] getMonsters() {
        int count = 0;
        for (GameCharacter character : characters) {
            if (character instanceof Monster && character.getHealth() > 0) {
                count++;
            }
        }
        Monster[] livingMonsters = new Monster[count];
        int index = 0;
        for (GameCharacter character : characters) {
            if (character instanceof Monster && character.getHealth() > 0) {
                livingMonsters[index] = (Monster) character;
                index++;
            }
        }
        return livingMonsters;
    }

    // 获取所有角色的方法
    public GameCharacter[] getCharacters() {
        return characters;
    }

    // 获取地图布局字符串的方法
    public String getLayoutAsString() {
        StringBuilder layoutString = new StringBuilder();
        for (String[] row : layout) {
            for (String cell : row) {
                layoutString.append(cell);
            }
            layoutString.append("\n");
        }
        return layoutString.toString();
    }
}
