package com.example.coding_test.programmers;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] fibonacci = new int[n];

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for(int i = 2; i < n; i++) {
            fibonacci[i] = (fibonacci[i-1]%1234567 + fibonacci[i-2]%1234567)%1234567;
        }

        return fibonacci[n-1];
    }
}
