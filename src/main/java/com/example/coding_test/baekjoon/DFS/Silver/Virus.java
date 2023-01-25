package com.example.coding_test.baekjoon.DFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//문제 URL https://www.acmicpc.net/problem/2606
public class Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int pair = Integer.parseInt(sc.nextLine());

        //인접 행렬로 연결 정보 받기
        int[][] pairInfo = new int[N+1][N+1];
        for (int i = 0; i < pair; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            pairInfo[x][y] = 1;
            pairInfo[y][x] = 1;
        }

        System.out.println(bfs(pairInfo));
    }

    public static int bfs (int[][] pairInfo) {
        int count = 0;

        //시작점 Queue에 넣기
        Queue<Integer> queue = new LinkedList<>();
        //1번 컴퓨터가 감염되었을 때를 확인하는 문제
        queue.add(1);

        //컴퓨터의 수를 중복을 제거하고 알기 위해 check할 수 있는 boolean[] 생성
        boolean[] virusCheck = new boolean[pairInfo.length-1];
        virusCheck[0] = true;
        while (!queue.isEmpty()) {
            int checkLine = queue.poll();
            //현재 라인에 감염된 컴퓨터가 있는지 확인하고
            for (int i = 1; i < pairInfo.length; i++) {
                // 이미 검사한 컴퓨터는 검사할 필요가 없다.
                if (!virusCheck[i-1]) {
                    if (pairInfo[checkLine][i] == 1) {
                        // 있다면 q에 추가
                        queue.add(i);
                        //check에 표시
                        virusCheck[i-1] = true;
                        //count증가
                        count++;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(virusCheck));
        return count;
    }
}
