package com.example.coding_test.baekjoon.DFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FloorDecoration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        String[][] floorDecoration = new String[x][y];
        int index = 0;
        for (int i = 0; i < x; i++) {
            stk = new StringTokenizer(br.readLine());
            floorDecoration[i] = stk.nextToken().split("");
        }

        System.out.println(solution(x, y, floorDecoration));
    }
    //방문처리를 할 boolean[][]
    static boolean[][] visited;
    private static int solution(int x, int y, String[][] floorDecoration) {
        int answer = 0;

        visited = new boolean[x][y];

        //0,0부터 순차적으로 확인
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                //방문한적 없는 곳이면 검사
                if (!visited[i][j]) {
                    //'-'이면 bfs로(가로) 같은 모양인 타일이 있는지 검사
                    if (floorDecoration[i][j].equals("-")) {
                        answer += bfs(floorDecoration, i, j, y) > 0 ? 1 : 0;
                    }
                    //'|'이면 dfs로(세로) 같은 모양인 타일이 있는지 검사
                    if (floorDecoration[i][j].equals("|")) {
                        answer += dfs(floorDecoration, i, j, x, 0) > 0? 1 : 0;
                    }
                }
            }
        }

        return answer;
    }

    public static int dfs (String[][] floorDecoration, int x, int y, int height, int count) {
        if (x == height) {
            return count;
        }

        if (floorDecoration[x][y].equals("|") && !visited[x][y]) {
            visited[x][y] = true;
            return dfs(floorDecoration, x+1, y, height, ++count);
        }
        else {
            return count;
        }
    }

    public static int bfs (String[][] floorDecoration, int x, int y, int width) {
        int count = 1;

        for (int i = y; i < width; i++) {
            if (floorDecoration[x][i].equals("-") && !visited[x][i]) {
                visited[x][i] = true;
                count++;
            }
            else
                return count;
        }
        return count;
    }
}
