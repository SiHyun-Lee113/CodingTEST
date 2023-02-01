package com.example.coding_test.programmers_level1;

import java.util.*;

public class PersonalityType {
    public static void main(String[] args) {
        String[] survey = {"RT", "TR", "RT"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    static int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
    static String[] Type = {"R", "T", "C", "F", "J", "M", "A", "N"};
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : Type) {
            map.put(s, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String[] split = survey[i].split("");
            if (choices[i] > 4) {
                map.put(split[1], map.get(split[1]) + score[choices[i]]);
            } else if (choices[i] == 4);
            else {
                map.put(split[0], map.get(split[1]) + score[choices[i]]);
            }
        }

        if (map.get("R") >= map.get("T")) answer += "R";
        else answer += "T";

        if (map.get("C") >= map.get("F")) answer += "C";
        else answer += "F";

        if (map.get("J") >= map.get("M")) answer += "J";
        else answer += "M";

        if (map.get("A") >= map.get("N")) answer += "A";
        else answer += "N";

        return answer;
    }
}
