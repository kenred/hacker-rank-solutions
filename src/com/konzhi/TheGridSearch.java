package com.konzhi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by konzhi on 1/26/17.
 */
/*
https://www.hackerrank.com/challenges/the-grid-search
 */
public class TheGridSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            ArrayList<String> gridRows = new ArrayList<>(R);
            while (R > 0) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    gridRows.add(line);
                    R--;
                }
            }
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            ArrayList<String> patternRows = new ArrayList<>(r);
            while (r > 0) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    patternRows.add(line);
                    r--;
                }
            }
            boolean found = false;
            for (int i = 0; i < gridRows.size() - c + 1; i++) {
                int indexGrid = gridRows.get(i).indexOf(patternRows.get(0));

                while (indexGrid >= 0) {
                    boolean match = true;
                    int patternCounter = 1;
                    while (match && patternCounter < patternRows.size()) {
                        String substring = gridRows.get(i + patternCounter).substring(indexGrid);
                        String patternRow = patternRows.get(patternCounter);
                        match &= substring.startsWith(patternRow);
                        if (!match) {
                            break;
                        }
                        patternCounter++;
                    }
                    if (match) {
                        System.out.println("YES");
                        found = true;
                        break;
                    }
                    indexGrid = gridRows.get(i).indexOf(patternRows.get(0), indexGrid + 1);
                }
            }
            if (!found) {
                System.out.println("NO");
            }
            T--;
        }
    }
}
