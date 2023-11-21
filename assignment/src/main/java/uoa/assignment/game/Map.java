package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

    public String[][] layout;
    public GameCharacter[] characters;

    public Map(int height, int width) {
        layout = new String[height][width]; // 初始化2D数组
        characters = new GameCharacter[4]; // 初始化长度为4的角色数组
        initialiseArray(); // 调用初始化数组的方法
        createCharacters(); // 调用创建角色的方法
    }

    private void initialiseArray() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = "."; // 用'.'填充数组
            }
        }
    }

    private void createCharacters() {
        characters[0] = new Player("Player"); // 创建一个 Player 实例并放入数组中
        characters[0].setRow(layout.length - 1); // 将玩家放在底部
        characters[0].setColumn(layout[0].length - 1); // 将玩家放在右侧
        layout[layout.length - 1][layout[0].length - 1] = "*"; // 在布局数组中标记玩家位置为 '*'

        characters[1] = new Monster("Monster1"); // 创建第一个 Monster 实例并放入数组中
        characters[1].setRow(0); // 将怪物1放在顶部
        characters[1].setColumn(layout[0].length - 1); // 将怪物1放在右侧
        layout[0][layout[0].length - 1] = "%"; // 在布局数组中标记怪物1位置为 '%'

        characters[2] = new Monster("Monster2"); // 创建第二个 Monster 实例并放入数组中
        characters[2].setRow(layout.length - 1); // 将怪物2放在底部
        characters[2].setColumn(0); // 将怪物2放在左侧
        layout[layout.length - 1][0] = "%"; // 在布局数组中标记怪物2位置为 '%'

        characters[3] = new Monster("Monster3"); // 创建第三个 Monster 实例并放入数组中
        characters[3].setRow(0); // 将怪物3放在顶部
        characters[3].setColumn(0); // 将怪物3放在左侧
        layout[0][0] = "%"; // 在布局数组中标记怪物3位置为 '%'
    }
    public void printLayout() {
        for (String[] row : layout) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public Player getPlayer() {
        for (GameCharacter character : characters) {
            if (character instanceof Player) {
                return (Player) character;
            }
        }
        return null; // 如果找不到玩家，返回null
    }

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

    public GameCharacter[] getCharacters() {
        return characters;
    }
}
