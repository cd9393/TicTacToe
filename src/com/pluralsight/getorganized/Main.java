package com.pluralsight.getorganized;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        printArray(input);

        int numberOfXs = countChar(input,'X');
        int numberOfOs = countChar(input, 'O');

        boolean xWins = checkWins(input,'X');
        boolean oWins = checkWins(input,'O');

        if (numberOfOs - numberOfXs > 1 || numberOfXs - numberOfOs > 1 || (oWins && xWins)) {
            System.out.println("Impossible");
            return;
        } else if (xWins && !oWins) {
            System.out.println("X wins");
        } else if (oWins && !xWins) {
            System.out.println("O wins");
        } else if (numberOfOs + numberOfXs == 9) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    public static void printArray(String input) {
        char[] charArray = input.toCharArray();

        System.out.println("---------");

        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + charArray[i] +" " + charArray[i + 1] +" " + charArray[i + 2] + " |");
        };

        System.out.println("---------");
    }

    public static int countChar(String string, char c) {
        int count = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkWins(String string, char c) {
        boolean wins = false;
        int winValue = 0;
        if (c == 'X'){
            winValue = 264;
        } else {
            winValue = 237;
        }
        for (int i = 0; i < 9; i += 3) {
            int sum = string.charAt(i) + string.charAt(i + 1) + string.charAt(i + 2);
            if (sum == winValue) {
                wins = true;
                break;
            }
        }

        for (int i = 0; i < 3; i++) {
            int sum = string.charAt(i) + string.charAt(i + 3) + string.charAt(i + 6);
            if (sum == winValue) {
                wins = true;
                break;
            }
        }

        if (string.charAt(0) + string.charAt(4) + string.charAt(8) == winValue) {
            wins = true;
        }else if (string.charAt(2) + string.charAt(4) + string.charAt(6) == winValue){
            wins = true;
        }
        return wins;
    }
}
