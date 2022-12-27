package com.example.coding_test.algorithm;

import java.util.*;
import java.io.*;

public class BFS {
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
        bfs(V);
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;
        System.out.print(v + " \t");

        while(!queue.isEmpty()) {
            System.out.println(queue);
            int temp = queue.poll();
            for(int i = 0; i < arr.length; i++) {
                if(arr[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " \t");
                }
            }
        }
    }
}
