import java.util.Scanner;

public class Othello {
	static Scanner s = new Scanner(System.in);

	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public static void main(String[] args) {
		OthelloBoard b = new OthelloBoard();
		b.print();
		System.out.println("Any Integer to Play  //  -1 -> End Game ");
		int n = s.nextInt();
		boolean p1Turn = true;
		while(n != -1) {
			if(p1Turn) {
				System.out.println("Player 1's Turn");
			}
			else {
				System.out.println("Player 2's Turn");
			}
			System.out.println("X cordinate");
			int x = s.nextInt();
			System.out.println("Y cordinate");
			int y = s.nextInt();
			boolean ans = false;
			if(p1Turn) {
				ans = b.move(player1Symbol, x, y);
			}
			else {
				ans = b.move(player2Symbol, x, y);
			}
			if(ans) {
				b.print();
				p1Turn = !p1Turn;
			}
			else {
				System.out.println("Invalid Move");
				System.out.println("Try Again");
			}
			System.out.println("Any Integer to Play  //  -1 -> End Game ");
			n = s.nextInt();
		}
		System.out.println("Game Ended");
	}
}
