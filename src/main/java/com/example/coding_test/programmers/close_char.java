package com.example.coding_test.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
//d
public class close_char {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if(map.containsKey(key)) {
                answer[i] = i - map.get(key);
                map.put(key, i);
            } else {
                answer[i] = -1;
                map.put(key, i);
            }
        }


        return answer;
    }
}
