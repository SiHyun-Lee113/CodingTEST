package com.example.coding_test;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }

    static Queue<Mapping> input_queue = new LinkedList<>();
    static Queue<Mapping> output_queue = new LinkedList<>();

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        int i = 0;
        for (int priority : priorities) {
            input_queue.add(new Mapping(i, priority));
            i++;
        }

        while(!input_queue.isEmpty()) {
            Mapping cur = input_queue.poll();
            if (check(cur)) {
                output_queue.add(cur);
            } else {
                input_queue.add(cur);
            }
        }
        answer = 1;
        for (Mapping mapping1 : output_queue) {
            if (location == mapping1.key)
                return answer;
            else answer++;
        }
        return answer;
    }

    private static boolean check(Mapping mapping) {
        int max = Integer.MIN_VALUE;

        for (Mapping mapping1 : input_queue) {
            if (max <= mapping1.value)
                max = mapping1.value;
        }

        return max <= mapping.value;
    }

    static class Mapping {
        int key;
        int value;

        public Mapping(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Mapping{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
