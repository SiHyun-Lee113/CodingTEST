package com.example.coding_test.baekjoon.BFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AtoK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        System.out.println(bfs(A, K, 0));
    }

    public static int bfs(int a, int k, int count) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[k+1];

        queue.add(new int[]{a, 0});
        visited[a] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == k)
                return poll[1];

            if (poll[0]*2 < k) {
                queue.add(new int[]{poll[0]*2, poll[1]+1});
                visited[poll[0]*2] = true;
            }

            if (!visited[poll[0]+1]) {
                visited[poll[0]+1] = true;
                queue.add(new int[]{poll[0]+1, poll[1]+1});
            }
        }
        return -1;
    }
}
