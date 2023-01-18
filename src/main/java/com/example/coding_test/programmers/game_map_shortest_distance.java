package com.example.coding_test.programmers;

import java.util.*;

public class game_map_shortest_distance {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        System.out.println(solution(maps));
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if (answer == 0)
            return -1;
        for (int[] ints : visited) {
            System.out.println(Arrays.toString(ints));
        }
        return answer;
    }

    public static int bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = 1;
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            int cx = cxy[0];
            int cy = cxy[1];

            for(int i = 0; i<4; i++) {
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;
                if (nx >= maps.length || nx < 0 || ny >= maps[0].length || ny < 0) {
                    continue;
                }
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }


        return -1;
    }
}