package com.example.coding_test.baekjoon.Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class br_11404_gold4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int city = Integer.parseInt(br.readLine());
        int route = Integer.parseInt(br.readLine());

        long[][] board = new long[city][city];

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (i == j)
                    board[i][j] = 0;
                else
                    board[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < route; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(stk.nextToken())-1;
                int y = Integer.parseInt(stk.nextToken())-1;
                int cost = Integer.parseInt(stk.nextToken());

                board[x][y] = Math.min(board[x][y], cost);
        }

        for (int K = 0; K < city; K++) {
            for (int S = 0; S < city; S++) {
                for (int E = 0; E < city; E++) {
                    board[S][E] = Math.min(board[S][E], board[S][K] + board[K][E]);
                }
            }
        }

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (board[i][j] > Integer.MAX_VALUE)
                    System.out.print(0 + " ");
                else
                    System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}