package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.game.Map;

import java.util.List;

import static uoa.assignment.game.GameLogic.moveCharacter;

public class Game {
    private Map map;

    Game(int height, int width) {
        map = new Map(height, width); // 实例化并初始化一个 Map 对象
        map.printLayout(); // 打印地图布局到控制台
    }

    public Map getMap() {
        return map;
    }

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

    public GameCharacter getPlayer() {
        return map.getPlayer();
    }

    public List<Monster> getMonsters() {
        return List.of(map.getMonsters());
    }
}