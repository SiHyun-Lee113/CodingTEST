package com.example.coding_test.baekjoon.Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1956_gold4 {
    static int N;
    static int M;
    static int[][] board;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        board = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j)
                    board[i][j] = INF;
            }
        }
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            board[x][y] = Integer.parseInt(stk.nextToken());
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                        board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
                }
            }
        }

        int min = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                if (board[i][j] != INF && board[j][i] != INF)
                    min = Math.min(min, board[i][j]+board[j][i]);

            }
        }
        if (min == INF)
            min = -1;

        System.out.println(min);
    }
}
