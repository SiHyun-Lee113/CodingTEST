package com.example.coding_test.programmers;

import java.util.ArrayList;
import java.util.List;

public class discount_event {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int number_sum = 0;
        for(int i : number) {
            number_sum += i;
        }

        for(int i = 0; i <= discount.length - number_sum; i++){
            int correct = 0;
            List<String> user_want = new ArrayList<>();

            for(int k = 0; k < want.length; k++) {
                for(int j = 0; j < number[k]; j++) {
                    user_want.add(want[k]);
                }
            }
            System.out.println(i + " " +(number_sum+i));
            for(int j = i; j < number_sum+i; j++) {

                if(user_want.remove(discount[j])) {
                    correct++;
                }
            }
            if (correct == number_sum)
                answer++;
        }

        return answer;
    }
}
/**
 * 1 ~ 10
 * 2 ~ 11
 * 3 ~ 12
 * 4 ~ 13
 * 5 ~ 14
 * */