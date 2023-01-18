package com.example.coding_test.programmers;

import java.util.Arrays;

public class Repeat_Binary_Conversion {
    public static void main(String[] args) {
        String s = "1111111";


        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int[] answer = new int[2];

        int zero_count = 0;
        int conversion_count = 0;

        while(!(s.equals("1"))) {
            int before_size = 0;
            before_size = s.length();
            s = s.replaceAll("0", "");
            zero_count += before_size - s.length();
            s = int_to_binary(s.length());
            conversion_count++;
        }
        answer[0] = conversion_count;
        answer[1] = zero_count;

        return answer;
    }

    private static String int_to_binary(int i) {
        String result = "";

        while(i > 0) {
            result += i % 2;
            i /= 2;
        }

        return result;
    }
}
