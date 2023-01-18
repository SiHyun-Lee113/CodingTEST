package com.example.coding_test.programmers;

import java.util.*;

public class find_prime {
    public static void main(String[] args) {
        String numbers = "1234";

        System.out.println(solution(numbers));
    }

    private static int solution(String numbers) {
        int answer = 0;
        String[] s = numbers.split("");
        for(int j = 1; j <= s.length; j++) {
            permutation(s, new int[j], new boolean[s.length], 0, j);
        }
        System.out.println(list);
        for(int i : list) {
            if(prime_check(i)) {
              answer++;
            }
        }

        return answer;
    }

    private static boolean prime_check(int num) {
        if(num == 2)
            return true;
        if(num == 1 || num == 0 || num % 2 == 0)
            return false;
        for(int i = 3; i < (int)Math.sqrt(num); i += 2) {
            if(num % i == 0)
                return false;
        }

        return true;
    }

    static Set<Integer> list = new HashSet<>();

    public static void permutation(String[] arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            String number = "";
            for(int num: out) {
                number += num;
            }
            list.add(Integer.parseInt(number));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = Integer.parseInt(arr[i]);
                permutation(arr, out, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
