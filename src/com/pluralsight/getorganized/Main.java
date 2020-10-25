package com.pluralsight.getorganized;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        //Get 3 x 3 field from the input
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        //Output this 3x3 field with cells before the user's move,
        printArray(board);

        //Then ask the user about his next move

        //Then the user should input 2 numbers that represent the cell on which user wants to make his X or O
        int i = 0;
        while (i < 9) {
            i++;
            char personsTurn = 'X';
            if (i % 2 == 0) {
                personsTurn = 'X' ;
            } else {
                personsTurn = 'O';
            }

            boolean incorrectCoordinates = true;

            while (incorrectCoordinates) {
                System.out.println("Enter coordinates:");
                // Check coordinates entered are ints
                while (!scanner.hasNextInt()) {
                    System.out.println("You should enter numbers");
                }

                int coordinate1 = scanner.nextInt();
                int coordinate2 = scanner.nextInt();

                // Check coordinates are between 1 and 3
                if((coordinate1 < 1 || coordinate1 > 3) || (coordinate2 < 0 || coordinate2 > 3)) {
                    System.out.println("Coordinates should be from 1 to 3");
                }else if (board[3-coordinate2][coordinate1-1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[3-coordinate2][coordinate1-1] = personsTurn;
                    incorrectCoordinates = false;
                }
            }

            printArray(board);

            int numberOfXs = countChar(board,'X');
            int numberOfOs = countChar(board, 'O');

            boolean xWins = checkWins(board,'X');
            boolean oWins = checkWins(board,'O');

            if (numberOfOs - numberOfXs > 1 || numberOfXs - numberOfOs > 1 || (oWins && xWins)) {
                System.out.println("Impossible");
            } else if (xWins && !oWins) {
                System.out.println("X wins");
                break;
            } else if (oWins && !xWins) {
                System.out.println("O wins");
                break;
            } else if (numberOfOs + numberOfXs == 9) {
                System.out.println("Draw");
                break;
            }

        }
    }

    public static void printArray(char[][] board) {

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.println("---------");
    }

    public static int countChar(char[][] board, char c) {
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == c) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkWins(char[][] board, char c) {
        boolean wins = false;
        int winValue = 0;
        if (c == 'X'){
            winValue = 264;
        } else {
            winValue = 237;
        }
        for (int i = 0; i < 3; i++) {
            int sum = board[i][0] + board[i][1] + board[i][2];
            if (sum == winValue) {
                wins = true;
                break;
            }
        }

        for (int i = 0; i < 3; i++) {
            int sum = board[0][i] + board[1][i] + board[2][i];
            if (sum == winValue) {
                wins = true;
                break;
            }
        }

        if (board[0][0] + board[1][1] + board[2][2] == winValue) {
            wins = true;
        }else if (board[0][2] + board[1][1] + board[2][0] == winValue){
            wins = true;
        }
        return wins;
    }
}
