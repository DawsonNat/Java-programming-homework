package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		if (!input.equals("up") && !input.equals("down") && !input.equals("left") && !input.equals("right")) {
			System.out.println("Use only keywords up, down, left, right");
			return;
		}
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

//	private static void moveRight(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX + 1 < gameMap.layout[0].length && (gameMap.layout[currentY][currentX + 1].equals(".") || gameMap.layout[currentY][currentX + 1].equals("%"))) {
//			// 检查右侧是否有其他角色
//			if (checkCollision(gameMap, currentX + 1, currentY)) {
//				System.out.println("Monster already there so it cannot move");
//			} else {
//				gameMap.layout[currentY][currentX + 1] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setColumn(currentX + 1);
//			}
//		} else {
//			System.out.println("You can't go right. You lose a move.");
//		}
//	}
//
//	private static void moveLeft(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX - 1 >= 0 && (gameMap.layout[currentY][currentX - 1].equals(".") || gameMap.layout[currentY][currentX - 1].equals("%"))) {
//			if (checkCollision(gameMap, currentX - 1, currentY)) {
//				System.out.println("Monster already there so it cannot move");
//			} else {
//				gameMap.layout[currentY][currentX - 1] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setColumn(currentX - 1);
//			}
//		} else {
//			System.out.println("You can't go left. You lose a move.");
//		}
//	}
//
//	private static void moveUp(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentY - 1 >= 0 && (gameMap.layout[currentY - 1][currentX].equals(".") || gameMap.layout[currentY - 1][currentX].equals("%"))) {
//			if (checkCollision(gameMap, currentX, currentY - 1)) {
//				System.out.println("Monster already there so can't move");
//			} else {
//				gameMap.layout[currentY - 1][currentX] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setRow(currentY - 1);
//			}
//		} else {
//			System.out.println("You can't go up. You lose a move.");
//		}
//	}
//
//	private static void moveDown(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentY + 1 < gameMap.layout.length && (gameMap.layout[currentY + 1][currentX].equals(".") || gameMap.layout[currentY + 1][currentX].equals("%"))) {
//			if (checkCollision(gameMap, currentX, currentY + 1)) {
//				System.out.println("Monster already there so it cannot move");
//			} else {
//				gameMap.layout[currentY + 1][currentX] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setRow(currentY + 1);
//			}
//		} else {
//			System.out.println("You can't go down. You lose a move.");
//		}
//	}

//	private static void moveRight(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX + 1 < gameMap.layout[0].length && (gameMap.layout[currentY][currentX + 1].equals(".") || gameMap.layout[currentY][currentX + 1].equals("%"))) {
//			// 检查右侧是否有其他角色
//			GameCharacter targetCharacter = getCharacterAtPosition(gameMap, currentX + 1, currentY);
//			if (targetCharacter != null) {
//				if (character instanceof Player && targetCharacter instanceof Monster) {
//					Player player = (Player) character;
//					Monster monster = (Monster) targetCharacter;
//					if (!monster.successfulDefense()) {
//						System.out.println("Player successfully attacked the monster!");
//						player.hurtCharacter(monster);
//						if (monster.getHealth() <= 0) {
//							System.out.println("The monster is dead!");
//							gameMap.layout[monster.getRow()][monster.getColumn()] = "x";
//						}
//					} else {
//						System.out.println("Player's attack was unsuccessful!");
//					}
//				} else if (character instanceof Monster && targetCharacter instanceof Player) {
//					Monster monster = (Monster) character;
//					Player player = (Player) targetCharacter;
//					if (!player.successfulDefense()) {
//						System.out.println("Monster successfully attacked the player!");
//						monster.hurtCharacter(player);
//						if (player.getHealth() <= 0) {
//							System.out.println("The player is dead!");
//						}
//					} else {
//						System.out.println("Monster's attack was unsuccessful!");
//					}
//				}
//			} else {
//				gameMap.layout[currentY][currentX + 1] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setColumn(currentX + 1);
//			}
//		} else {
//			System.out.println("You can't go right. You lose a move.");
//		}
//	}
//
//	private static void moveLeft(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX + 1 < gameMap.layout[0].length && (gameMap.layout[currentY][currentX - 1].equals(".") || gameMap.layout[currentY][currentX - 1].equals("%"))) {
//			// 检查右侧是否有其他角色
//			GameCharacter targetCharacter = getCharacterAtPosition(gameMap, currentX - 1, currentY);
//			if (targetCharacter != null) {
//				if (character instanceof Player && targetCharacter instanceof Monster) {
//					Player player = (Player) character;
//					Monster monster = (Monster) targetCharacter;
//					if (!monster.successfulDefense()) {
//						System.out.println("Player successfully attacked the monster!");
//						player.hurtCharacter(monster);
//						if (monster.getHealth() <= 0) {
//							System.out.println("The monster is dead!");
//							gameMap.layout[monster.getRow()][monster.getColumn()] = "x";
//						}
//					} else {
//						System.out.println("Player's attack was unsuccessful!");
//					}
//				} else if (character instanceof Monster && targetCharacter instanceof Player) {
//					Monster monster = (Monster) character;
//					Player player = (Player) targetCharacter;
//					if (!player.successfulDefense()) {
//						System.out.println("Monster successfully attacked the player!");
//						monster.hurtCharacter(player);
//						if (player.getHealth() <= 0) {
//							System.out.println("The player is dead!");
//						}
//					} else {
//						System.out.println("Monster's attack was unsuccessful!");
//					}
//				}
//			} else {
//				gameMap.layout[currentY][currentX - 1] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setColumn(currentX - 1);
//			}
//		} else {
//			System.out.println("You can't go right. You lose a move.");
//		}
//	}
//
//	private static void moveUp(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentY - 1 < gameMap.layout[0].length && (gameMap.layout[currentY - 1][currentX].equals(".") || gameMap.layout[currentY - 1][currentX].equals("%"))) {
//			// 检查右侧是否有其他角色
//			GameCharacter targetCharacter = getCharacterAtPosition(gameMap, currentX, currentY - 1);
//			if (targetCharacter != null) {
//				if (character instanceof Player && targetCharacter instanceof Monster) {
//					Player player = (Player) character;
//					Monster monster = (Monster) targetCharacter;
//					if (!monster.successfulDefense()) {
//						System.out.println("Player successfully attacked the monster!");
//						player.hurtCharacter(monster);
//						if (monster.getHealth() <= 0) {
//							System.out.println("The monster is dead!");
//							gameMap.layout[monster.getRow()][monster.getColumn()] = "x";
//						}
//					} else {
//						System.out.println("Player's attack was unsuccessful!");
//					}
//				} else if (character instanceof Monster && targetCharacter instanceof Player) {
//					Monster monster = (Monster) character;
//					Player player = (Player) targetCharacter;
//					if (!player.successfulDefense()) {
//						System.out.println("Monster successfully attacked the player!");
//						monster.hurtCharacter(player);
//						if (player.getHealth() <= 0) {
//							System.out.println("The player is dead!");
//						}
//					} else {
//						System.out.println("Monster's attack was unsuccessful!");
//					}
//				}
//			} else {
//				gameMap.layout[currentY - 1][currentX] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setRow(currentY - 1);
//			}
//		} else {
//			System.out.println("You can't go right. You lose a move.");
//		}
//	}
//
//	private static void moveDown(GameCharacter character, Map gameMap) {
//		int currentX = character.getColumn();
//		int currentY = character.getRow();
//		if (currentX + 1 < gameMap.layout[0].length && (gameMap.layout[currentY + 1][currentX].equals(".") || gameMap.layout[currentY + 1][currentX].equals("%"))) {
//			// 检查右侧是否有其他角色
//			GameCharacter targetCharacter = getCharacterAtPosition(gameMap, currentX, currentY + 1);
//			if (targetCharacter != null) {
//				if (character instanceof Player && targetCharacter instanceof Monster) {
//					Player player = (Player) character;
//					Monster monster = (Monster) targetCharacter;
//					if (!monster.successfulDefense()) {
//						System.out.println("Player successfully attacked the monster!");
//						player.hurtCharacter(monster);
//						if (monster.getHealth() <= 0) {
//							System.out.println("The monster is dead!");
//							gameMap.layout[monster.getRow()][monster.getColumn()] = "x";
//						}
//					} else {
//						System.out.println("Player's attack was unsuccessful!");
//					}
//				} else if (character instanceof Monster && targetCharacter instanceof Player) {
//					Monster monster = (Monster) character;
//					Player player = (Player) targetCharacter;
//					if (!player.successfulDefense()) {
//						System.out.println("Monster successfully attacked the player!");
//						monster.hurtCharacter(player);
//						if (player.getHealth() <= 0) {
//							System.out.println("The player is dead!");
//						}
//					} else {
//						System.out.println("Monster's attack was unsuccessful!");
//					}
//				}
//			} else {
//				gameMap.layout[currentY + 1][currentX] = gameMap.layout[currentY][currentX];
//				gameMap.layout[currentY][currentX] = ".";
//				character.setRow(currentY + 1);
//			}
//		} else {
//			System.out.println("You can't go right. You lose a move.");
//		}
//	}
//
//	// 添加碰撞检测方法
//	private static boolean checkCollision(Map gameMap, int x, int y) {
//		for (GameCharacter character : gameMap.getCharacters()) {
//			if (character.getColumn() == x && character.getRow() == y) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private static GameCharacter getCharacterAtPosition(Map gameMap, int x, int y) {
//		for (GameCharacter character : gameMap.getCharacters()) {
//			if (character.getColumn() == x && character.getRow() == y) {
//				return character;
//			}
//		}
//		return null;
//	}

