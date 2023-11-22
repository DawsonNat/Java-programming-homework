package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	// 移动角色的方法
	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		// 检查输入是否合法
		if (!input.equals("up") && !input.equals("down") && !input.equals("left") && !input.equals("right")) {
			System.out.println("Use only keywords up, down, left, right");
			return;
		}
		// 根据输入执行相应的移动操作
		switch (input) {
			case "right":
				moveRight(character, gameMap);
				break;
			case "left":
				moveLeft(character, gameMap);
				break;
			case "up":
				moveUp(character, gameMap);
				break;
			case "down":
				moveDown(character, gameMap);
				break;
		}
	}

	private static void moveRight(GameCharacter character, Map gameMap) {
		if (character.column + 1 >= gameMap.layout[0].length) {
			System.out.println("You can't go right. You lose a move.");
			return;
		}
		String old = gameMap.layout[character.row][character.column];
		if (gameMap.layout[character.row][character.column + 1] != ".") {
			if (old == "%") {
				if (gameMap.layout[character.row][character.column + 1] == "*") {
					character.hurtCharacter(gameMap.characters[0]);
				} else {
					System.out.println("Monster already there so can't move");
				}
			} else {
				for (int i = 1; i < gameMap.characters.length; i++) {
					if (gameMap.characters[i].row == character.row && gameMap.characters[i].column == character.column + 1) {
						character.hurtCharacter(gameMap.characters[i]);
						if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
						}
						break;
					}
				}
			}
			return;
		}
		gameMap.layout[character.row][character.column + 1] = old;
		gameMap.layout[character.row][character.column] = ".";
		character.column += 1;
	}

	private static void moveLeft(GameCharacter character, Map gameMap) {
		if (character.column - 1 < 0) {
			System.out.println("You can't go left. You lose a move.");
			return;
		}
		String old = gameMap.layout[character.row][character.column];
		if (gameMap.layout[character.row][character.column - 1] != ".") {
			if (old == "%") {
				if (gameMap.layout[character.row][character.column - 1] == "*") {
					character.hurtCharacter(gameMap.characters[0]);
				} else {
					System.out.println("Monster already there so can't move");
				}
			} else {
				GameCharacter monster;
				for (int i = 1; i < gameMap.characters.length; i++) {
					if (gameMap.characters[i].row == character.row && gameMap.characters[i].column == character.column - 1) {
						character.hurtCharacter(gameMap.characters[i]);
						if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
						}
						break;
					}
				}
			}
			return;
		}
		gameMap.layout[character.row][character.column - 1] = old;
		gameMap.layout[character.row][character.column] = ".";
		character.column -= 1;
	}

	private static void moveUp(GameCharacter character, Map gameMap) {
		if (character.row - 1 < 0) {
			System.out.println("You can't go up. You lose a move.");
			return;
		}
		String old = gameMap.layout[character.row][character.column];
		if (gameMap.layout[character.row - 1][character.column] != ".") {
			if (old == "%") {
				if (gameMap.layout[character.row - 1][character.column] == "*") {
					character.hurtCharacter(gameMap.characters[0]);
				} else {
					System.out.println("Monster already there so can't move");
				}
			} else {
				GameCharacter monster;
				for (int i = 1; i < gameMap.characters.length; i++) {
					if (gameMap.characters[i].row == character.row - 1 && gameMap.characters[i].column == character.column) {
						character.hurtCharacter(gameMap.characters[i]);
						if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
						}
						break;
					}
				}
			}
			return;
		}
		gameMap.layout[character.row - 1][character.column] = old;
		gameMap.layout[character.row][character.column] = ".";
		character.row -= 1;
	}

	private static void moveDown(GameCharacter character, Map gameMap) {
		if (character.row + 1 >= gameMap.layout.length) {
			System.out.println("You can't go down. You lose a move.");
			return;
		}
		String old = gameMap.layout[character.row][character.column];
		if (gameMap.layout[character.row + 1][character.column] != ".") {
			if (old == "%") {
				if (gameMap.layout[character.row + 1][character.column] == "*") {
					character.hurtCharacter(gameMap.characters[0]);
				} else {
					System.out.println("Monster already there so can't move");
				}
			} else {
				GameCharacter monster;
				for (int i = 1; i < gameMap.characters.length; i++) {
					if (gameMap.characters[i].row == character.row + 1 && gameMap.characters[i].column == character.column) {
						character.hurtCharacter(gameMap.characters[i]);
						if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
						}
						break;
					}
				}
			}
			return;
		}
		gameMap.layout[character.row + 1][character.column] = old;
		gameMap.layout[character.row][character.column] = ".";
		character.row += 1;
	}
}


