package com.konzhi.datastructures.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by konzhi on 2/11/17.
 * https://www.hackerrank.com/challenges/queries-with-fixed-length
 */
public class QeriesWithFIxesLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;

        while (i < n) {
            arr[i++] = scanner.nextInt();
        }

        while (q > 0) {
            q--;
            Deque<Integer> queue = new LinkedList<>();
            int queryWindowSize = scanner.nextInt();
            for (int j = 0; j < queryWindowSize; j++) {
                queue.addFirst(arr[j]);
            }
            int min = maxInQueue(queue);
            int max = maxInQueue(queue);
            for (int k = queryWindowSize; k < n; k++) {
                int last = queue.pollLast();
                queue.addFirst(arr[k]);
                if (last == max) {
                    max = maxInQueue(queue);
                }
                if (min > max) {
                    min = max;
                }
            }
            System.out.println(min);
        }
    }

    private static int maxInQueue(Deque<Integer> arr) {
        int max = arr.getFirst();
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
        }
        return max;
    }
}
/*
7 1
7 3 14 5 8 11 0
3
 */