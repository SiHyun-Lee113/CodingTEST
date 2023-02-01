package com.example.coding_test.programmers_level2;

import java.util.*;

public class SeesawGame {
    public static void main(String[] args) {
        int[] weights = {100,180,360,100,270};

        System.out.println(solution(weights));
    }

    public static int[][] rates = {{1, 1}, {3, 2}, {4, 2}, {4, 3}};
    public static long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        for (int[] rate : rates) {
            for (int i = 0; i < weights.length; i++) {
                int x = weights[i];

                if ((x * rate[0]) % rate[1] != 0)
                    continue;
                int y = (x * rate[0]) / rate[1];

                int upper = upperBound(y, weights, i + 1, weights.length);
                int lower = lowerBound(y, weights, i + 1, upper);

                answer += (upper - lower);
            }
        }

        return answer;
    }

    private static int upperBound(int findWeight, int[] weights, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (findWeight < weights[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int lowerBound(int findWeight, int[] weights, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (findWeight <= weights[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}