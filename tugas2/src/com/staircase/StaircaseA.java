package com.staircase;

import java.util.Scanner;

public class StaircaseA {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Input n : ");
        n = input.nextInt();

        // condition
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
