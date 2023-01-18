package com.example.coding_test.programmers_level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class n_LCM {
    public static void main(String[] args) {
        int[] arr = {2, 14, 8, 6};

        System.out.println(solution(arr));
    }

    // 6, 24, 56
    // 1 2 3 4 6 8 12 24
    // 1 2 4 7 8 16 28 56
    // 24, 168
    // 168
    public static long solution(int[] arr) {
        long answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : arr) list.add(i);

        while (list.size() > 1) {
            int num1 = list.remove(0);
            int num2 = list.remove(0);
            int lcm = (num1*num2) / getLCM(num1, num2);
            list.add(lcm);
        }
        answer = list.get(0);
        return answer;
    }

    public static int getLCM (int num1, int num2) {
        int r = num1 % num2;
        if (r == 0)
            return num2;
        else
            return getLCM(num2, r);
    }
}
