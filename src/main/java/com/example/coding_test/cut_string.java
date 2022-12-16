package com.example.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class cut_string {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        System.out.println(solution(stk.nextToken()));

    }

    private static int solution(String s) {
        char first = s.charAt(0);
        int count = 0; int diff = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == diff) {
                answer++;
                first = s.charAt(i);
            }
            if (first == s.charAt(i)) {
                count++;
            } else {
                diff++;
            }
        }
        return answer;
    }
}
