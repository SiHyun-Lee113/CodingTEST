package com.example.coding_test.programmers;

import java.util.*;

public class cut_roll_cake {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        HashSet<Integer> first = new HashSet<>();
        HashMap<Integer, Integer> second = new HashMap<>();

        first.add(topping[0]);
        for (int i = 1;i < size; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }
        System.out.println(second);

        for (int i = 1;i < size; i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i]) - 1);
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            if (first.size() == second.size()) answer++;
        }


        return answer;
    }
}