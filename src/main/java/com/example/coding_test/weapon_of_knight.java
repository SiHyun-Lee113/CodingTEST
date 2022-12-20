package com.example.coding_test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class weapon_of_knight {
    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        System.out.println(solution(number, limit, power));
    }

    private static int solution(int number, int limit, int power) {
        int answer = 0;
        int[] weapon_of_knight = new int[number];


        for(int i = 1; i <= number; i++) {
            int count = 0;
            for(int j = 1; j * j<=i; j++) {
                if(i % j == 0) {
                    count++;
                    if ( j * j < i) {
                        count++;
                    }
                }

            }
            weapon_of_knight[i-1] = count;
        }
        System.out.println(Arrays.toString(weapon_of_knight));

        for(int i : weapon_of_knight) {
            if(i <= limit)
                answer += i;
            else
                answer += power;
        }
        return answer;
    }
}
