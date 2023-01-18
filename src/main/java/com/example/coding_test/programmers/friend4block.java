package com.example.coding_test.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class friend4block {
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 4;
        int n = 5;

        System.out.println(solution(m, n, board));
    }
    static boolean visit[][];

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] input = new char[m][n];
        for(int i = 0; i < m; i++) {
            input[i] = board[i].toCharArray();
        }

        boolean flag = true;

        while(flag) {
            visit = new boolean[m][n];
            flag = false;

            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if (input[i][j] == '#')
                        continue;
                    if(check(i, j, input)) {
                        visit[i][j] = true;
                        visit[i + 1][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            answer += delete(m, n, input);
        }

        return answer;
    }

    private static int delete(int m, int n, char[][] input) {
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j])
                    input[i][j] = '.';
            }
        }

        /* 큐를 이용해 세로로 제거 작업 진행 */
        for(int i=0; i<n; i++){
            Queue<Character> q = new LinkedList<>();
            for(int j=m-1; j>=0; j--){
                if(input[j][i] == '.'){
                    count++;  // 지우는 블록 카운트
                }else{
                    q.add(input[j][i]);
                }
            }

            int idx=m-1;
            // 삭제한 블록 위의 블록들 내리기
            while(!q.isEmpty()){
                input[idx--][i] = q.poll();
            }
            // 빈칸 채우기
            for(int j=idx; j>=0; j--){
                input[j][i] = '#';
            }
        }
        for (char[] l : input) {
            for (char c : l) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
        return count;
    }

    private static boolean check(int i, int j, char[][] input) {
        char ch = input[i][j];
        if(ch == input[i][j+1]
        && ch == input[i+1][j]
        && ch == input[i+1][j+1]) {
            return true;
        }
        return false;
    }
}
