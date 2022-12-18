package com.example.coding_test;

import java.util.*;

public class picking_tangerines {
    public static void main(String[] args) {
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 6;

        System.out.println(solution(k, tangerine));
    }

    private static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : tangerine) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int count = 0;
        for(int i : list) {
            count += i;
            answer++;
            if(count >= k)
                break;
        }

        return answer;
    }
}
