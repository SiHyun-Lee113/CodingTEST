package com.example.coding_test.baekjoon.Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2458_gold4 {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        boolean[][] board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken())-1;
            int y = Integer.parseInt(stk.nextToken())-1;

            board[x][y] = true;
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][k] && board[k][j]) {
                        board[i][j] = true;
                    }
                }
            }
        }

        int[] count = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] || board[j][i])
                    count[i]++;
            }
        }

        int result = 0;
        for (int i : count) {
            if (i == N)
                result++;
        }

        System.out.println(result);
    }
}
