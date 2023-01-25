package com.example.coding_test.baekjoon.DFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JumpKingJelly {
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        board = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        dfs(0, 0);

        System.out.println("Hing");
    }

    public static boolean[][] visited;
                            //우    //하
    static int[][] move = {{0, 1}, {1, 0}};
    private static void dfs(int x, int y) {
        if (board[x][y] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }
        for (int i = 0; i < 2; i++) {
            int next_x = x + board[x][y] * move[i][1];
            int next_y = y + board[x][y] * move[i][0];
            if (next_x >= N || next_y >= N || visited[next_x][next_y]) continue;

            visited[next_x][next_y] = true;
            dfs(next_x, next_y);
        }
    }
}
