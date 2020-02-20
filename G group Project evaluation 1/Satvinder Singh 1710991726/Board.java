import java.util.*;
public class Board {
	static Scanner s = new Scanner(System.in);

	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public static void main(String[] args) {
		OthelloBoard b = new OthelloBoard();
		System.out.print("Enter value 1 to start or -1 to end the game");
		int n = s.nextInt();
		boolean p1Turn = true;
		while(n != -1 ) {
			boolean ans;
			if(p1Turn) {
				System.out.println("Player 1's Turn : ");
				System.out.print("enter X cordinate :");
				int x = s.nextInt();
				System.out.print("enter Y cordinate :");
				int y = s.nextInt();
				ans = false;
				ans = b.move(player1Symbol, x, y);
			}
			else {
				System.out.println("Player 2's Turn : ");
				System.out.print("enter X cordinate :");
				int x = s.nextInt();
				System.out.println("enter Y cordinate :");
				int y = s.nextInt();
				ans = false;
				ans = b.move(player2Symbol, x, y);
			}
			if(ans) {
				b.print();
				p1Turn = !p1Turn;
				n--;
				System.out.println("Enter value 1 to start or -1 to end the game");
			}
			else {
				System.out.println(ans);
				System.out.println("Enter value 1 to start or -1 to end the game");
			}
			n = s.nextInt();
		}
		System.out.println("Game Over");
	}
}
