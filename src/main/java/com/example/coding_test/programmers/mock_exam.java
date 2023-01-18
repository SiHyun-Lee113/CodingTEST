package com.example.coding_test.programmers;

import java.util.*;

public class mock_exam {
    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2, 1, 3, 4, 5,2, 1,2, 3, 4, 5, 2, 1, 1, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }
    static int[] first = new int[]{1, 2, 3, 4, 5};
    static int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};;
    static int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int first_count = 0;
        int second_count = 0;
        int third_count = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i%5]) first_count++;

            if(answers[i] == second[i%8]) second_count++;

            if(answers[i] == third[i%10]) third_count++;
        }
//        System.out.println("first_count = " + first_count);
//        System.out.println("second_count = " + second_count);
//        System.out.println("third_count = " + third_count);

        int[][] rank = new int[3][2];
        rank[0] = new int[]{1, first_count};
        rank[1] = new int[]{2, second_count};
        rank[2] = new int[]{3, third_count};

//        System.out.println(Arrays.deepToString(rank));

        Arrays.sort(rank, (o1, o2) -> {return ( o2[1] - o1[1]);});

//        System.out.println(Arrays.deepToString(rank));

        List<Integer> result = new ArrayList<>();
        int top = rank[0][1];
        for(int i = 0; i < rank.length; i++) {
            if(rank[i][1] == top)
                result.add(rank[i][0]);
        }

        answer = result.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
/**
 *
 *
 * 1번 수포자가 찍는 방식:
 * 1, 2, 3, 4, 5,
 * 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식:
 * 2, 1, 2, 3, 2, 4, 2, 5,
 * 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식:
 * 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
 * 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * */