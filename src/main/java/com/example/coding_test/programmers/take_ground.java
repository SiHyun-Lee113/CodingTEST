package com.example.coding_test.programmers;

import java.util.*;

public class take_ground {
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}};

        System.out.println(solution(land));
    }
    public static int solution(int[][] land) {
        int answer = 0;

        int[] answers = new int[4];
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][2], Math.max(land[i-1][3], land[i-1][0]));
            land[i][2] += Math.max(land[i-1][3], Math.max(land[i-1][1], land[i-1][0]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        System.out.println(Arrays.toString(land[land.length -1]));
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer,land[land.length-1][i]);
        }

        return answer;
    }
}
