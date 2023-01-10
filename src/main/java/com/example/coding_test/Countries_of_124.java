package com.example.coding_test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Countries_of_124 {
    public static void main(String[] args) {
        int n = 15;

        for (int i = 10; i < 20; i++)
            System.out.println(solution(i));
    }
    static String[] numbers = {"4", "1", "2"};
    public static String solution(int n) {
        String answer = "";


        while (n > 0) {
            int r = n % 3;
            if (r == 0)
                n--;
            answer = numbers[r] + answer;
            n /= 3;

        }

        return answer;
    }


}
