package com.example.coding_test.programmers_level1;

import java.util.*;

public class ThreeMusketeers {
    public static void main(String[] args) {
//        int[] number = {-2, 3, 0, 2, -5};
//        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int[] number = {-1, 1, -1, 1};
        System.out.println(solution(number));
    }
    static List<int[]> list = new ArrayList<>();
    public static int solution(int[] number) {

        combination(number, new boolean[number.length], 0, 0, new int[3]);

        return list.size();
    }

    public static void combination(int[] number, boolean[] visited, int start, int depth, int[] output) {
        if (depth == 3){
            if (check(output)) {
                list.add(output);

            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = number[i];
                combination(number, visited, i+1, depth+1, output);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int[] output) {
        int sum = 0;
        for (int i : output)
            sum += i;

        return sum == 0;
    }
}
