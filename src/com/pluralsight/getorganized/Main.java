package com.pluralsight.getorganized;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] charArray = input.toCharArray();

        System.out.println("---------");

        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + charArray[i] +" " + charArray[i + 1] +" " + charArray[i + 2] + " |");
        };

        System.out.println("---------");
    }
}
