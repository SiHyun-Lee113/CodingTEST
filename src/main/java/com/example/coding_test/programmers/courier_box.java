package com.example.coding_test.programmers;

import java.util.Stack;

public class courier_box {
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};

        System.out.println(solution(order));
    }

    private static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> sub_container = new Stack<>();
        int i = 0;

        for(int box = 1; box <= order.length; box++) {
            if(order[i] != box) {
                sub_container.add(box);
                continue;
            }

            i++;
            answer++;

            while(!sub_container.isEmpty() && order[i] == sub_container.peek()) {
                sub_container.pop();
                i++;
                answer++;
            }
        }

        return answer;
    }
}
/**
 * 4 3 1 2 5
 * main             sub             bus
 * 1 2 3 4 5
 * 2 3 4 5          1
 * 3 4 5            1 2
 * 4 5              1 2 3
 * 5                1 2 3           4
 * 5                1 2             4 3
 *
 * */
