package com.example.coding_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class the_next_number {
    public static void main(String[] args) {
        int n = 15;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        String s = Integer.toBinaryString(n);
        int one_count = Integer.bitCount(n);
        int next = n;

        while(true) {
            if (one_count == Integer.bitCount(++next)) {
                break;
            }
    }
        return next;
    }
}
