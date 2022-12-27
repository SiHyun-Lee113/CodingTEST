package com.example.coding_test.algorithm;

import java.util.*;
import java.io.*;

public class DFS {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        arr = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        visited = new boolean[N + 1];
        dfs(V);
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " \t");

        if(v == arr.length)
            return;

        for(int i = 1; i < arr.length; i++) {
            if(arr[v][i] == 1 && !visited[i]) { //i가 증가하다가 연결되어있고
                dfs(i);                         //방문하지 않았던 곳을 찾으면
            }                                   //재귀
        }
    }
}
