package com.example.coding_test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Magic_Elevator {
    public static void main(String[] args) {
        int storey = 35;

        System.out.println(solution(storey));
    }

    public static int solution(int storey) {
        int answer = 0;

        List<Integer> storey_list = new ArrayList<>();
        while(storey > 0) {
            storey_list.add(storey % 10);
            storey /= 10;
        }

        int[] arr = new int[storey_list.size()+1];

        for(int i = 0; i < storey_list.size(); i++) {
            arr[i] = storey_list.get(i);
        }
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 5) {
                if (arr[i+1] <= 4) {
                    answer += arr[i];
                } else {
                    arr[i+1]++;
                    answer += 10 - arr[i];
                }

            } else if (arr[i] > 5) {
                    arr[i+1]++;
                    answer += 10 - arr[i];
            }
            else {
                answer += arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));

        return answer;
    }
}
