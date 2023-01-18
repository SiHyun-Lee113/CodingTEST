package com.example.coding_test.programmers;

import java.util.*;

public class fruit_seller {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(solution(k, m, score));
    }

    private static int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i : score) {
            list.add(i);
        }
        list.sort(Collections.reverseOrder());

        for(int i = m; i <= list.size(); i += m) {
            answer += list.get(i-1) * m;
            System.out.println(list.get(i-1));
        }

        return answer;
    }
}
