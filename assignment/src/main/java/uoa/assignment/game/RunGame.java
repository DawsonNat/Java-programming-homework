package uoa.assignment.game;

import uoa.assignment.character.Monster;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
		int height = Integer.parseInt(args[0]); // 从命令行参数中获取地图高度
		int width = Integer.parseInt(args[1]); // 从命令行参数中获取地图宽度

		Game game = new Game(height, width); // 创建一个新的 Game 对象，传入地图的高度和宽度

		int round = 1; // 初始化回合数

		while (!gameOver) {
			System.out.println("Round " + round); // 打印回合数到控制台
			Scanner scanner = new Scanner(System.in); // 创建一个新的 Scanner 对象来接收用户输入
			String input = scanner.nextLine(); // 读取用户输入
			gameOver = game.nextRound(input); // 调用游戏对象的下一回合方法，并根据返回值更新游戏结束状态
			round++; // 增加回合数

			// 打印地图布局
			game.getMap().printLayout();

			// 打印角色健康状态
			System.out.println("Health Player: " + game.getPlayer().getHealth());
			for (Monster monster : game.getMonsters()) {
				System.out.println("Health " + monster.getName() + ": " + monster.getHealth());
			}
		}
	}
}
