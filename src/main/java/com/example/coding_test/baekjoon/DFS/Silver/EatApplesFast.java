package com.example.coding_test.baekjoon.DFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EatApplesFast {
    public static void main(String[] args) throws IOException {
        // TODO 아직 해결이 안됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int[][] board = new int[5][5];
        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int location = Integer.parseInt(stk.nextToken());
                board[i][j] = location;
                if (location < 0) {
                    visited[i][j] = true;
                }
            }
        }
        stk = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        int haveToEat = 3;

        boolean[] move_check = new boolean[4];
        System.out.println(dfs(x, y, visited, board, haveToEat, 0, move_check));
        System.out.println(Arrays.deepToString(visited));
    }
                        //  우       좌       하       상
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int dfs(int x, int y, boolean[][] visited, int[][] board, int haveToEat, int count, boolean[] move_check) {
        System.out.println(x + "  " + y);
        //현위치에 사과가 있으면 haveToEat--;
        if (!visited[x][y] && board[x][y] == 1)
            haveToEat--;
        //haveToEat이 0이면 종료
        if (haveToEat == 0)
            return count;
        //이동
        for (int i = 0; i < 4; i++) {
            if (!move_check[i]) {
                move_check[i] = true;
                int next_x = x + move[i][0];
                int next_y = y + move[i][1];

                //갈수 있는지 확인
                if (next_x > 0 && next_y > 0 && next_x < board.length && next_y < board.length) {
                    // 장해물이 있는지, 원래 갔던 곳인지 확인
                    if (board[next_x][next_y] != -1 && !visited[next_x][next_y]) {
                        //사과가 있는지 확인
                        haveToEat = board[next_x][next_y] == 1 ? haveToEat-1 : haveToEat;
                        //방문 처리
                        visited[next_x][next_y] = true;
                        //방문 횟수 증가
                        count++;
                        //다음 자리 확인
                        move_check = new boolean[4];
                        dfs(next_x, next_y, visited, board, haveToEat, count, move_check);
                    }
                }
                //갈 수 없을 때
                if (next_x > 0 && next_y > 0 && next_x < board.length && next_y < board.length) {
                    count = 0;
                    haveToEat = 3;
                    visited[next_x][next_y] = true;
                    dfs(x, y, visited, board, haveToEat, count, move_check);
                }
            }
        }
        return 0;
    }
}
