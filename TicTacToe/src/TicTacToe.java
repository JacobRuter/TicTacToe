import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		char[] [] gameBoard = {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
				
				
		printGameBoard(gameBoard);
				

				
				while(true) {
					Scanner scan = new Scanner(System.in);
					System.out.println("Enter your placement for next move (1-9):");
					int pos = scan.nextInt();
					while(playerPositions.contains(pos) || cpuPositions.contains(playerPositions)) {
						System.out.println("position taken! please enter an open spot");
						pos = scan.nextInt();
				}
					
					
					Place(gameBoard, pos, "player");
					
					Random rand = new Random();
					int cpuPos = rand.nextInt(9) + 1;
					
					while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
						
					 cpuPos = rand.nextInt(9) + 1;
	}
					Place(gameBoard, cpuPos, "Computer");
					
					printGameBoard(gameBoard);
						
					String result = checkWinner();
					System.out.println(result);
					}
		
				}

	
	public static void printGameBoard(char[] [] gameBoard) {
		for(char [] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
			}
	}
	
	public static void Place(char [] [] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} 
		else if(user.equals("Computer")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		
		switch(pos) {
		case 1:
			gameBoard[0] [0] = symbol;
			break;
		case 2:
			gameBoard[0] [2] = symbol;
			break;
		case 3:
			gameBoard[0] [4] = symbol;
			break;
		case 4:
			gameBoard[2] [0] = symbol;
			break;
		case 5:
			gameBoard[2] [2] = symbol;
			break;
		case 6:
			gameBoard[2] [4] = symbol;
			break;
		case 7:
			gameBoard[4] [0] = symbol;
			break;
		case 8:
			gameBoard[4] [2] = symbol;
			break;
		case 9:
			gameBoard[4] [4] = symbol;
			break;
			default:
				break;
			}

	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List leftA = Arrays.asList(1, 5, 9);
		List rightA = Arrays.asList(7, 5, 3);
			
					
					List<List> winning = new ArrayList<List>();
					winning.add(topRow);
					winning.add(midRow);
					winning.add(botRow);
					winning.add(leftCol);
					winning.add(rightCol);
					winning.add(midCol);
					winning.add(leftA);
					winning.add(rightA);
					
					for(List l : winning) {
						if(playerPositions.containsAll(l)) {
							return "You Won!";
						}
						else if(cpuPositions.containsAll(l)) {
							return"CPU wins!";
						}
						else if(playerPositions.size() + cpuPositions.size() == 9) {
						return "Tie";
						}
					}
					
		return "";
		
	}
}


