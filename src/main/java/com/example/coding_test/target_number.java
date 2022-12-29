package com.example.coding_test;

import java.util.Arrays;

public class target_number {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = dfs(numbers, 0, 0, target);
        System.out.println(answer);
//        System.out.println(solution(numbers, target));
    }

    public static int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length)
            return sum == target ? 1 : 0;

        return dfs(numbers, n+1, sum + numbers[n], target) +
                dfs(numbers, n+1, sum - numbers[n], target);
    }

    private static int solution(int[] numbers, int target) {
        int answer = 0;

        String[] order = new String[(int)Math.pow(2, numbers.length)];

        for(int i = 0; i < order.length; i++) {
            String num_binary = Integer.toBinaryString(i);

            while(num_binary.length() < numbers.length) {
                    num_binary = "0" + num_binary;
            }
            order[i] = num_binary;
            System.out.println(num_binary);
        }


        for(String s : order) {
            int check = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    check += numbers[i];
                } else {
                    check += (-1*numbers[i]);
                }
            }
            if (check == target)
                answer++;
        }
        return answer;
    }
}
