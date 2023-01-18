package com.example.coding_test.programmers;

import java.util.*;

public class hall_of_fame {
    public static void main(String[] args) {
        int[] input = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int k = 4;

        System.out.println(Arrays.toString(solution(input, k)));
    }

    private static int[] solution(int[] input, int k) {
        int[] answer = new int[input.length];

        List<Integer> hall_of_fame = new ArrayList<>();

        for(int i = 0; i < input.length; i++) {
            if(hall_of_fame.size() < k) {
                hall_of_fame.add(input[i]);
                hall_of_fame.sort(Collections.reverseOrder());
                answer[i] = hall_of_fame.get(hall_of_fame.size()-1);
            } else {
                hall_of_fame.add(input[i]);
                hall_of_fame.sort(Collections.reverseOrder());
                hall_of_fame.remove(k);
                answer[i] = hall_of_fame.get(hall_of_fame.size()-1);
            }
        }

        return answer;
    }
}
