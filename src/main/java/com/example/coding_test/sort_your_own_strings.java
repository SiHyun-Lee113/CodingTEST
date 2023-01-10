package com.example.coding_test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class sort_your_own_strings {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted(
                        ((o1, o2) ->
                        {return o1.charAt(n) == o2.charAt(n)
                                ? o1.compareTo(o2) : o1.charAt(n) - o2.charAt(n);}))
                .toArray(String[]::new);
    }
}
