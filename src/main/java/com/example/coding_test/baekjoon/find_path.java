package com.example.coding_test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class find_path {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        int[][] maps = new int[n][n];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        solution(maps, n);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    static int N;
    static int[][] result;
    static boolean[] visited;
    private static void solution(int[][] maps, int n) {
        result = maps;
        N = n;

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            for(int j = 0; j < N; j++) {
                if (result[i][j] == 1 && !visited[j])
                    dfs(i, j);
            }
        }
    }

    public static void dfs(int x, int y) {
        visited[y] = true;
        result[x][y] = 1;

        for(int i = 0; i < N; i++) {
            if (result[y][i] == 1 && !visited[i])
                dfs(x, i);
        }
    }
}
/**
 3
 0 1 0
 0 0 1
 1 0 0
 *
 7
 0 0 0 1 0 0 0
 0 0 0 0 0 0 1
 0 0 0 0 0 0 0
 0 0 0 0 1 1 0
 1 0 0 0 0 0 0
 0 0 0 0 0 0 1
 0 0 1 0 0 0 0
 *
 * */
