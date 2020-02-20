package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TicTacToe t = new TicTacToe();
        Scanner s = new Scanner(System.in);
        int x = 0, y = 0;
        do {
            System.out.println(t.player == TicTacToe.X ? "Player X turn" : "Player O turn");
            System.out.println("Enter x and y places");
            x = s.nextInt();
            y = s.nextInt();

            t.putSign(x, y);
            System.out.println(t.toString());
            System.out.println("___________");
            t.displayWinner();

        } while (t.isEmpty);
    }
}