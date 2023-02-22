package com.staircase;

import java.util.Scanner;

public class StaircaseD {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Input n : ");
        n = input.nextInt();

        // condition
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print(i + j + 1);
                }
                else if (i + j == n - 1) {
                    System.out.print(2 * j + 1);
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
