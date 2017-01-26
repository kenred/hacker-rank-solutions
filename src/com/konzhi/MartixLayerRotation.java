package com.konzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by konzhi on 1/24/17.
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class MartixLayerRotation {

    private static void printMatrix(int[][] matrix, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }

    private static LinkedList<Integer> buildList(int[][] matrix, int M, int N, int num) {
        LinkedList<Integer> llist = new LinkedList<>();
        int maxM = M - num;
        int maxN = N - num;
        int m = num;
        int n = num;
        while (m < maxM) {
            llist.addLast(matrix[m][n]);
            m++;
        }
        m--;
        n++;

        while (n < maxN) {
            llist.addLast(matrix[m][n]);
            n++;
        }
        n--;
        m--;

        while (m > num - 1) {
            llist.addLast(matrix[m][n]);
            m--;
        }
        m++;
        n--;

        while (n > num) {
            llist.addLast(matrix[m][n]);
            n--;
        }
        return llist;
    }

    private static void populate(int[][] matrix, int M, int N, List<LinkedList<Integer>> lists) {
        int num = 0;
        for (LinkedList<Integer> llist : lists) {
            int maxM = M - num;
            int maxN = N - num;
            int m = num;
            int n = num;
            while (m < maxM) {
                matrix[m][n] = llist.pop();
                m++;
            }
            m--;
            n++;

            while (n < maxN) {
                matrix[m][n] = llist.pop();
                n++;
            }
            n--;
            m--;

            while (m > num - 1) {
                matrix[m][n] = llist.pop();
                m--;
            }
            m++;
            n--;

            while (n > num) {
                matrix[m][n] = llist.pop();
                n--;
            }
            num++;
        }
    }

    private static void rotate(LinkedList<Integer> llist, int steps) {
        steps = steps % llist.size();
        while (steps > 0) {
            Integer tail = llist.pollLast();
            llist.addFirst(tail);
            steps--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int R = scanner.nextInt();
        int[][] matrix = new int[M][N];

        int i = 0;
        int k = 0;
        while (i < M && scanner.hasNext()) {
            matrix[i][k++] = scanner.nextInt();
            if (k == N) {
                k = 0;
                i++;
            }
        }

        List<LinkedList<Integer>> lists = new ArrayList<>();

        int min = Math.min(M, N);
        for (int j = 0; j < min / 2; j++) {
            lists.add(buildList(matrix, M, N, j));
        }

        for (LinkedList<Integer> l : lists) {
            rotate(l, R);
        }

        populate(matrix, M, N, lists);
        printMatrix(matrix, M, N);
    }

}
