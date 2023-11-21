package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		if (input.equals("up")) {
			moveUp(character, gameMap);
		} else if (input.equals("down")) {
			moveDown(character, gameMap);
		} else if (input.equals("left")) {
			moveLeft(character, gameMap);
		} else if (input.equals("right")) {
			moveRight(character, gameMap);
		} else {
			System.out.println("Use only keywords up, down, left, right"); // 如果输入值不是“up”、“down”、“left”或“right”，则打印错误消息到控制台
		}
	}

//	private static void moveRight(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX + 1 < gameMap.layout[0].length && gameMap.layout[currentY][currentX + 1].equals(".")) {
//			gameMap.layout[currentY][currentX] = ".";
//			gameMap.layout[currentY][currentX + 1] = String.valueOf(character.getSymbol());
//			character.setColumn(currentX + 1);
//		} else {
//			System.out.println("You can't go right. You lose a move.");
//		}
//	}

//	private static void moveLeft(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX - 1 >= 0 && gameMap.layout[currentY][currentX - 1].equals(".")) {
//			gameMap.layout[currentY][currentX] = ".";
//			gameMap.layout[currentY][currentX - 1] = String.valueOf(character.getSymbol());
//			character.setColumn(currentX - 1);
//		} else {
//			System.out.println("You can't go left. You lose a move.");
//		}
//	}
//
//	private static void moveUp(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentY - 1 >= 0 && gameMap.layout[currentY - 1][currentX].equals(".")) {
//			gameMap.layout[currentY][currentX] = ".";
//			gameMap.layout[currentY - 1][currentX] = String.valueOf(character.getSymbol());
//			character.setRow(currentY - 1);
//		} else {
//			System.out.println("You can't go up. You lose a move.");
//		}
//	}
//
//	private static void moveDown(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentY + 1 < gameMap.layout.length && gameMap.layout[currentY + 1][currentX].equals(".")) {
//			gameMap.layout[currentY][currentX] = ".";
//			gameMap.layout[currentY + 1][currentX] = String.valueOf(character.getSymbol());
//			character.setRow(currentY + 1);
//		} else {
//			System.out.println("You can't go down. You lose a move.");
//		}
//	}

	private static void moveRight(GameCharacter character, Map gameMap) {
		int currentX = character.getColumn();
		int currentY = character.getRow();
		if (currentX + 1 < gameMap.layout[0].length && gameMap.layout[currentY][currentX + 1].equals(".") || gameMap.layout[currentY][currentX + 1].equals("%")) {
			// 检查右侧是否有其他角色
			if (checkCollision(gameMap, currentX + 1, currentY)) {
				System.out.println("Monster already there so it cannot move");
			} else {
				gameMap.layout[currentY][currentX] = ".";
				gameMap.layout[currentY][currentX + 1] = String.valueOf(character.getSymbol());
				character.setColumn(currentX + 1);
			}
		} else {
			System.out.println("You can't go right. You lose a move.");
		}
	}

	private static void moveLeft(GameCharacter character, Map gameMap) {
		int currentX = character.getColumn();
		int currentY = character.getRow();
		if (currentX - 1 >= 0 && gameMap.layout[currentY][currentX - 1].equals(".") || gameMap.layout[currentY][currentX - 1].equals("%")) {
			if (checkCollision(gameMap, currentX - 1, currentY)) {
				System.out.println("Monster already there so it cannot move");
			} else {
				gameMap.layout[currentY][currentX] = ".";
				gameMap.layout[currentY][currentX - 1] = String.valueOf(character.getSymbol());
				character.setColumn(currentX - 1);
			}
		} else {
			System.out.println("You can't go left. You lose a move.");
		}
	}

	private static void moveUp(GameCharacter character, Map gameMap) {
		int currentX = character.getColumn();
		int currentY = character.getRow();
		if (currentY - 1 >= 0 && (gameMap.layout[currentY - 1][currentX].equals(".") || gameMap.layout[currentY - 1][currentX].equals("%"))) {
			if (checkCollision(gameMap, currentX, currentY - 1)) {
				System.out.println("Monster already there so can't move");
			} else {
				gameMap.layout[currentY][currentX] = ".";
				gameMap.layout[currentY - 1][currentX] = String.valueOf(character.getSymbol());
				character.setRow(currentY - 1);
			}
		} else {
			System.out.println("You can't go up. You lose a move.");
		}
	}

	private static void moveDown(GameCharacter character, Map gameMap) {
		int currentX = character.getColumn();
		int currentY = character.getRow();
		if (currentY + 1 < gameMap.layout.length && gameMap.layout[currentY + 1][currentX].equals(".") || gameMap.layout[currentY + 1][currentX].equals("%")) {
			if (checkCollision(gameMap, currentX, currentY + 1)) {
				System.out.println("Monster already there so it cannot move");
			} else {
				gameMap.layout[currentY][currentX] = ".";
				gameMap.layout[currentY + 1][currentX] = String.valueOf(character.getSymbol());
				character.setRow(currentY + 1);
			}
		} else {
			System.out.println("You can't go down. You lose a move.");
		}
	}

	// 添加碰撞检测方法
	private static boolean checkCollision(Map gameMap, int x, int y) {
		for (GameCharacter character : gameMap.getCharacters()) {
			if (character.getColumn() == x && character.getRow() == y) {
				return true;
			}
		}
		return false;
	}
}
