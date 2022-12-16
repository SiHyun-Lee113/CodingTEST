package com.example.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//d
public class expected_bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());


        System.out.println(solution(n, a, b));
    }
    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true) {
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;

            if(a == b)
                break;
        }

        return answer;
    }
}
