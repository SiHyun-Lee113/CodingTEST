package com.example.coding_test.programmers;

import java.util.*;

public class Phone_number_Book {
    public static void main(String[] args) {
        String[] phone_book = {"119", "234321", "1395524421"};

        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], i);

        for(int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j)))
                    return false;
            }
        }

        System.out.println(map);

        return answer;
    }
}
