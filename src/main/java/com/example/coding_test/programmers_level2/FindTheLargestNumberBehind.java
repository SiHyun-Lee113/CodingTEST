package com.example.coding_test.programmers_level2;

import java.util.*;

public class FindTheLargestNumberBehind {
    public static void main(String[] args) {
//        int[] numbers = {2, 3, 3, 5};
        int[] numbers = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        Stack<Integer> forCheck = new Stack<>();
        int[] result = new int[numbers.length];


        for (int i = numbers.length -1; i >= 0; i--) {
            if (forCheck.isEmpty()){
                forCheck.add(numbers[i]);
                result[i] = -1;
            } else {
                while (numbers[i] != 0) {
                    if (forCheck.isEmpty()) {
                        forCheck.add(numbers[i]);
                        result[i] = -1;
                        break;
                    } else if (numbers[i] >= forCheck.peek()) {
                        forCheck.pop();
                    } else {
                        result[i] = forCheck.peek();
                        forCheck.add(numbers[i]);
                        break;
                    }
                }
            }
        }

        return result;
    }
}
