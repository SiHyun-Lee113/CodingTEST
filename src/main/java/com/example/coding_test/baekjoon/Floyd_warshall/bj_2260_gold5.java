package com.example.coding_test.baekjoon.Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2260_gold5 {
    static int INF = 987987987;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine())+1;

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                board[i][j] = INF;
            }
        }

        while(true) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            if (x == -1 && y == -1)
                break;

            board[x][y] = 1;
            board[y][x] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                for (int k = 1; k < N; k++) {
                    board[j][k] = Math.min(board[j][k], board[j][i]+board[i][k]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == INF)
                    board[i][j] = 0;
            }
        }
        int[] lank = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = 1; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
            lank[i] = max;
            min = Math.min(min, max);
        }

        int winnerCount = 0;
        for (int i = 0; i < N; i++) {
            if (lank[i] == min)
                winnerCount++;
        }
        System.out.println(min + " " + winnerCount);
        for (int i = 0; i < N; i++) {
            if (lank[i] == min)
                System.out.print(i + " ");
        }
    }
}
