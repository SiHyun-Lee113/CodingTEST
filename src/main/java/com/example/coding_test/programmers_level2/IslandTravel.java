package com.example.coding_test.programmers_level2;

import java.util.*;

public class IslandTravel {
    public static void main(String[] args) {
//        String[] map = {"X591X","X1X5X","X231X", "1XXX1"};
        String[] map = {"XXX","XXX","XXX"};

        System.out.println(Arrays.toString(solution(map)));
    }

    public static int[] solution(String[] map) {
        List<Integer> answer = new ArrayList<>();
        boolean[][] visited = new boolean[map.length][map[0].length()];
        int[][] travelMap = new int[map.length][map[0].length()];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                char spot = map[i].charAt(j);
                if (spot != 'X') {
                    visited[i][j] = true;
                    travelMap[i][j] = spot - '0';
                }
            }
        }

        for (int i = 0; i < travelMap.length; i++) {
            for (int j = 0; j < travelMap[i].length; j++) {
                if (visited[i][j]) {
                    answer.add(bfs(travelMap, visited, i, j));
                }
            }
        }
        if (answer.size() == 0) {
            return new int[]{-1};
        }

        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int bfs(int[][] board, boolean[][] visited, int x, int y) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = false;
        count += board[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0]+dx[i];
                int nextY = cur[1]+dy[i];
                if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    count += board[nextX][nextY];
                    visited[nextX][nextY] = false;
                }
            }
        }

        return count;
    }
}
