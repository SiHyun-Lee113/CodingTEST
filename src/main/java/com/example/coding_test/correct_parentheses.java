package com.example.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class correct_parentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        char[] input = new char[s.length()];

        for(int i = 0; i < s.length();i++) {
            input[i] = s.charAt(i);
        }
        Stack<Character> stack = new Stack<>();

        if(Objects.equals(input[0], ")") || input.length % 2 == 1)
            return false;

        for (char value : input) {
            if (stack.isEmpty()) {
                stack.add(value);
            } else {
                int pair = 0;
                pair = ((int) stack.peek() - (int) value);

                if (pair == -1) {
                    stack.pop();
                } else {
                    stack.add(value);
                }
            }
        }
        return stack.isEmpty();
    }
}
