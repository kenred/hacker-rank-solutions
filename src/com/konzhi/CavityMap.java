package com.konzhi;

import java.util.Scanner;

/**
 * Created by konzhi on 1/27/17.
 * https://www.hackerrank.com/challenges/cavity-map?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class CavityMap {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int i = 0;
        while (i < n) {
            String line = scanner.next();
            int k = 0;
            while (k < n) {
                matrix[i][k] = Integer.parseInt(line.substring(k, k + 1));
                k++;
            }
            i++;
        }
        int[][] cavity = new int[n][n];

        for (i = 1; i < n - 1; i++) {
            for (int k = 1; k < n - 1; k++) {
                if (matrix[i][k] > matrix[i - 1][k] &&
                        matrix[i][k] > matrix[i + 1][k] &&
                        matrix[i][k] > matrix[i][k + 1] &&
                        matrix[i][k] > matrix[i][k - 1]
                        ) {
                    cavity[i][k] = 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (i > 0 && k > 0 && i < n - 1 && k < n - 1 && cavity[i][k] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print(matrix[i][k]);
                }
            }
            System.out.println();
        }

    }
}
