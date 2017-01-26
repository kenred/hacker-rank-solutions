package com.konzhi;

import java.util.Scanner;

/**
 * Created by konzhi on 1/26/17.
 * https://www.hackerrank.com/challenges/flipping-the-matrix
 */

/*
1
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108
 */

public class FlippingTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q > 0) {
            q--;
            int n = scanner.nextInt();
            int[][] matrix = new int[2 * n][2 * n];
            int i = 0;
            while (i < 2 * n) {
                int k = 0;
                while (k < 2 * n) {
                    matrix[i][k] = scanner.nextInt();
                    k++;
                }
                i++;
            }
            int sum = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    sum += Math.max(
                            Math.max(matrix[x][y], matrix[2 * n - 1 - x][y]),
                            Math.max(matrix[x][2 * n - 1 - y], matrix[2 * n - 1 - x][2 * n - 1 - y])
                    );
                }
            }
            System.out.println(sum);
        }


    }
}
