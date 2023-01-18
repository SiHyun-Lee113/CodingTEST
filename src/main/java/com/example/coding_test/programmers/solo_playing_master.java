package com.example.coding_test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class solo_playing_master {
    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
//        int[] cards = {
//                10, 2, 3, 4, 1,
//                6, 9, 5, 7, 8,
//                11};
        System.out.println(solution(cards));
    }
    static boolean[] visited;
    static List<Integer> group = new ArrayList<>();

    public static int solution(int[] cards) {
        int answer = 1;
        visited = new boolean[cards.length];

        for(int i = 0; i < cards.length; i++)
            if(!visited[i]) group.add(check(cards[i], cards));

        if(group.size() == 1 ) return 0;

        group.sort(Comparator.reverseOrder());
        answer = group.get(0) * group.get(1);

        return answer;
    }

    private static int check(int i, int[] cards) {
        int count = 0;
        int index = i;
        boolean[] v = new boolean[cards.length];
        while(!visited[index-1]) {
            visited[index-1] = true;
            v[index-1] = true;
            index = cards[index-1];
        }

        for(boolean b : v) if (b) count++;

        System.out.println(Arrays.toString(visited));
        System.out.println("count = " + count);
        return count;
    }
}
