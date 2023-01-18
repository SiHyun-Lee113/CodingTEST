package com.example.coding_test.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class defence_game {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        System.out.println(solution(n, k, enemy));
    }

    private static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> defense = new PriorityQueue<>();
        int i;
        for (i = 0; i < enemy.length; i++) {
            if (defense.isEmpty() || defense.size() < k) {
                defense.add(enemy[i]);
            }



            else {
                if (defense.peek() < enemy[i] && n - defense.peek() >= 0) {
                    n -= defense.poll();
                    defense.add(enemy[i]);
                } else if (n - enemy[i] >= 0) {
                    n -= enemy[i];
                } else {
                    break;
                }
            }
        }

        return i;
    }
}
