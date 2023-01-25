package com.example.coding_test.baekjoon.BFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ConnectedComponentCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int node = Integer.parseInt(stk.nextToken());
        int line = Integer.parseInt(stk.nextToken());
        int[][] inputs = new int[line][2];
        int[][] board = new int[node+1][node+1];
        boolean[] visited = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            inputs[i] = new int[]{x, y};

            board[x][y] = 1;
            board[y][x] = 1;

        }
        int count = 0;

        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                count++;
                bfs(board, visited, i);
            }
        }

        System.out.println(count);
    }

    private static void bfs(int[][] board, boolean[] visited, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        visited[x] = true;

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < board.length; i++) {
                if (!visited[i] && (board[poll][i] == 1 || board[i][poll] == 1))  {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
