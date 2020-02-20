package tic_tac_toe;

import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class TicTacToe {

	public static void main(String[] args) 
	{
		char [][] gameboard= {{' ' ,'|' ,' ','|',' '},
				          {'-','+','-','+','-'},
				          {' ' ,'|' ,' ','|',' '},
				          {'-' ,'+' ,'-','+','-'},
				          {' ' ,'|' ,' ','|',' '}};
		
		printGameBoard(gameboard);
		Scanner s=new Scanner(System.in);
		while(true)
		{
			//Scanner s=new Scanner(System.in);	
			System.out.println("Enter Placement(1-9):");
			int playerpos=s.nextInt();
			
			//System.out.println(playerpos);
			
			placeput(gameboard,playerpos,"player");
			
			Random r=new Random();
			
			int cpupos=r.nextInt(9)+1;
			
			placeput(gameboard,cpupos,"cpu");
			
			printGameBoard(gameboard);
		}
		
	}
	public static void printGameBoard(char[][]gameboard)
	{
	for(char[] row: gameboard)
	{
		for(char c: row)
		{
			System.out.print(c);
		}
		System.out.println();
	}
}
public static void  placeput(char[][] gameboard,int pos,String user)
{
	char symbol=' ';
	if(user.equals("player"))
	{
	  symbol='X';
	}
	else if(user.contentEquals("cpu"))
	{
	  symbol='O';
	}
	switch(pos)
	{
	case 1:
		gameboard[0][0]=symbol;
		break;
	case 2:
		gameboard[0][2]=symbol;
		break;
	case 3:
		gameboard[0][4]=symbol;
		break;
	case 4:
		gameboard[2][0]=symbol;
		break;
	case 5:
		gameboard[2][2]=symbol;
		break;
	case 6:
		gameboard[2][4]=symbol;
		break;
	case 7:
		gameboard[4][0]=symbol;
		break;
	case 8:
		gameboard[4][2]=symbol;
		break;
	case 9:
		gameboard[4][4]=symbol;
		break;
		default:
			break;
	}
}
public static String findwinner()
{
	List toprow=Arrays.asList(1,2,3);
	List midrow=Arrays.asList(4,5,6);
	List botrow=Arrays.asList(7,8,9);
	List leftcol=Arrays.asList(1,4,7);
	List midcol=Arrays.asList(2,5,8);
	List rightcol=Arrays.asList(3,6,9);
	List cross1=Arrays.asList(1,5,9);
	List cross2=Arrays.asList(7,5,3);

	List<List> winning=new ArrayList<List>();
	winning.add(toprow);
	winning.add(midrow);
	winning.add(botrow);
	winning.add(leftcol);
	winning.add(midcol);
	winning.add(rightcol);
	winning.add(cross1);
	winning.add(cross2);
	
	return"";
}
	
}
























