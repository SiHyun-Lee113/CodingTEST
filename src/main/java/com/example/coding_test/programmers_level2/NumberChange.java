package com.example.coding_test.programmers_level2;

import java.util.*;

public class NumberChange {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 30;

        System.out.println(solution(x, y, n));
    }

    private static int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, 0});
        while (!queue.isEmpty()) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            for (int[] ints : queue) {
//                System.out.print(Arrays.toString(ints) + " ");
//            }
//            System.out.println();
            int[] poll = queue.poll();

            if (x == poll[0])
                return poll[1];

            if (poll[0] % 3 == 0) {
                queue.add(new int[]{poll[0]/3, poll[1]+1});
            }
            if (poll[0] % 2 == 0) {
                queue.add(new int[]{poll[0]/2, poll[1]+1});
            }
            if (poll[0] - n >= x)
                queue.add(new int[]{poll[0]-n, poll[1]+1});

        }
//        HashSet<Integer> cur = new HashSet<>();
//        cur.add(x);
//        while (!cur.isEmpty()) {
//            if (cur.contains(y))
//                return count;
//
//            HashSet<Integer> next = new HashSet<>();
//            for (Integer integer : cur) {
//                int plus = integer + n;
//                int mul2 = integer * 2;
//                int mul3 = integer * 3;
//
//                if (plus <= y) next.add(plus);
//                if (mul2 <= y) next.add(mul2);
//                if (mul3 <= y) next.add(mul3);
//            }
//            cur = next;
//            count++;
//        }

        return -1;
    }
}
