package com.example.coding_test.baekjoon.BFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1389
public class bj_1389 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        int[][] board = new int[N+1][N+1];
        for (int i =1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    board[i][j] = 0;
                    continue;
                }
                board[i][j] = 100;
            }
        }

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());

                board[x][y] = 1;
                board[y][x] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
                }
            }
        }

        int min_index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = Arrays.stream(board[i]).sum();
            if (min > sum) {
                min = sum;
                min_index = i;
            }
        }

//        for (int[] ints : board) {
//            System.out.println(Arrays.toString(ints));
//        }
        System.out.println(min_index);
    }
}
