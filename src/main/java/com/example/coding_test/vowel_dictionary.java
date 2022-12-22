package com.example.coding_test;

import java.util.ArrayList;
import java.util.List;

public class vowel_dictionary {
    public static void main(String[] args) {
        String s = "I";

        System.out.println(solution(s));
    }
    static int level1 = (int)Math.pow(5, 4) + (int)Math.pow(5, 3) + (int)Math.pow(5, 2) + (int)Math.pow(5, 1) + (int)Math.pow(5, 0);
    static int level2 = (int)Math.pow(5, 3) + (int)Math.pow(5, 2) + (int)Math.pow(5, 1) + (int)Math.pow(5, 0);
    static int level3 = (int)Math.pow(5, 2) + (int)Math.pow(5, 1) + (int)Math.pow(5, 0);
    static int level4 = (int)Math.pow(5, 1) + (int)Math.pow(5, 0);
    static int level5 = (int)Math.pow(5, 0);
    static int[] level = {level1, level2, level3, level4, level5};
    private static int solution(String s) {
        int answer = 0;
        List<Character> dictionary = new ArrayList<>();

        dictionary.add('A');
        dictionary.add('E');
        dictionary.add('I');
        dictionary.add('O');
        dictionary.add('U');
        int s1 = 0;
        for(int i : level) {
            s1 += i;
        }

        for(int i = 0; i < s.length(); i++) {
            answer += dictionary.indexOf(s.charAt(i)) * level[i] + 1;
        }
        return answer;
    }
}
