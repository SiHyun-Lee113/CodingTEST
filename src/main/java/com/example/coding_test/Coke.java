package com.example.coding_test;

public class Coke {
    public static void main(String[] args) throws InterruptedException {
        int a = 2;
        int b = 1;
        int n = 20;

        System.out.println(solution(a, b, n));
    }

    public static int solution(int a, int b, int n) throws InterruptedException {
        int answer = 0;

        while(n > 1 && !(n < a)) {
            int coke = (n / a)* b;
            n = coke + n%a;
            answer += coke;
        }

        return answer;
    }
}
