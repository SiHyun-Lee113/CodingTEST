package com.example.coding_test.programmers_level2;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    private static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int last = people.length-1;

        int left_people = 0;
        int right_people = 0;
        int sum = 0;

        int count = 0;

        while (start < last) {
            count++;
            left_people = people[start];
            right_people = people[last];

            sum = left_people + right_people;
            System.out.println(left_people + "  " + right_people);
            if (sum <= limit) {
                start++;
                last--;
            } else {
                last--;
            }
            if (start == last) {
                count++;
                return count;
            }
        }

        return count;
    }
}
