package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.game.Map;

import java.util.List;

import static uoa.assignment.game.GameLogic.moveCharacter;

// 定义 Game 类
public class Game {
    private Map map; // 声明私有成员变量 map

    // 定义构造函数，接受两个整数参数 height 和 width
    Game(int height, int width) {
        map = new Map(height, width); // 实例化并初始化一个 Map 对象
        map.printLayout(); // 打印地图布局到控制台
    }

    // 定义方法 getMap，返回 map 对象
    public Map getMap() {
        return map;
    }

    // 定义方法 nextRound，接受一个字符串参数 input，返回布尔值
    public boolean nextRound(String input) {
        moveCharacter(input, map, map.getPlayer()); // 玩家移动
        System.out.println("Round 1");
        System.out.println(input); // 打印玩家移动方向
        boolean allMonstersDead = true;
        for (Monster monster : map.getMonsters()) {
            if (monster.getHealth() > 0) {
                allMonstersDead = false;
                String monsterMove = monster.decideMove(); // 获取怪物移动方向
                moveCharacter(monsterMove, map, monster); // 怪物移动
                System.out.println(monster.getName() + " is moving " + monsterMove); // 打印怪物移动方向
            }
        }
        System.out.println(map.getLayoutAsString()); // 打印地图布局到控制台
        System.out.println("Health Player: " + map.getPlayer().getHealth()); // 打印玩家健康状态
        for (Monster monster : map.getMonsters()) {
            System.out.println("Health " + monster.getName() + ": " + monster.getHealth()); // 打印怪物健康状态
        }
        if (allMonstersDead) {
            System.out.println("YOU HAVE WON!");
            return true;
        }
        if (map.getPlayer().getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");
            return true;
        }
        return true;
    }

    // 定义方法 getPlayer，返回 map 中的玩家对象
    public GameCharacter getPlayer() {
        return map.getPlayer();
    }

    // 定义方法 getMonsters，返回 map 中的怪物列表
    public List<Monster> getMonsters() {
        return List.of(map.getMonsters());
    }
}