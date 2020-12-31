package com.company;

import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (char c : input.toCharArray()) {
            System.out.print( "\\u" + Integer.toHexString(c | 0x10000).substring(1) );

        }
    }
}
