package com.example.coding_test.programmers;

import java.util.*;

public class delivery_and_collection {
    public static void main(String[] args) throws InterruptedException {
//        int cap = 4;
//        int n = 6;
//        int[] deliveries = {1, 0, 3, 1, 2, 0};
//        int[] pickups = {0, 3, 0, 4, 0, 8};
        int cap = 50;
        int n = 100000;
        int[] deliveries = new int[100000];
        int[] pickups = new int[100000];
        for(int i = 0; i < deliveries.length; i++) {
            deliveries[i] = 50;
            pickups[i] = 50;
        }
//        int cap = 2;
//        int n = 1;
//        int[] deliveries = {0};
//        int[] pickups = {0};
        /**
         * 1, 0, 2, 0, 1, 0, 0
         * 0, 2, 0, 1, 0, 2, 0
         * 1, 0, 1, 0, 0, 0, 0  6
         * 0, 2, 0, 1, 0, 0, 0  12
         * 0, 0, 0, 0, 0, 0, 0  16
         * 0, 1, 0, 0, 0, 0, 0  20
         * 24
         * */

        System.out.println(solution(cap, n, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        long beforeTime = System.currentTimeMillis();

        Stack<Integer> stack_delivery = new Stack<>();
        Stack<Integer> stack_pickup = new Stack<>();
        for(int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] > 0)
                stack_delivery.add(i+1);
            if (pickups[i] > 0)
                stack_pickup.add(i+1);
        }

        while(!stack_delivery.isEmpty() && !stack_pickup.isEmpty()) {
            int destination = Math.max(stack_delivery.peek(), stack_pickup.peek());
            if (destination == 0)
                break;

            int delivery_cap = cap;
            while (!stack_delivery.isEmpty()) {
                if (delivery_cap == 0)
                    break;
                int count = deliveries[stack_delivery.peek()-1] - delivery_cap;
                if (count > 0) {
                    deliveries[stack_delivery.peek()-1] = count;
                    delivery_cap = 0;
                } else {
                    deliveries[stack_delivery.peek()-1] = 0;
                    delivery_cap = Math.abs(count);
                    stack_delivery.pop();
                }
            }

            int pickup_cap = cap;
            while (!stack_pickup.isEmpty()) {
                if (pickup_cap == 0)
                    break;
                int count = pickups[stack_pickup.peek()-1] - pickup_cap;
                if (count > 0) {
                    pickups[stack_pickup.peek()-1] = count;
                    pickup_cap = 0;
                } else {
                    pickups[stack_pickup.peek()-1] = 0;
                    pickup_cap = Math.abs(count);
                    stack_pickup.pop();
                }
            }

            answer += destination * 2L;

        }
        answer = getAnswer(cap, deliveries, answer, stack_delivery);
        answer = getAnswer(cap, pickups, answer, stack_pickup);


        long afterTime = System.currentTimeMillis();
        long time = (afterTime - beforeTime);
        System.out.println("time = " + time);
        return answer;
    }

    private static long getAnswer(int cap, int[] deliveries, long answer, Stack<Integer> stack_delivery) {
        while (!stack_delivery.isEmpty()) {
            int destination = stack_delivery.peek();
            int delivery_cap = cap;
            while (!stack_delivery.isEmpty()) {
                if (delivery_cap == 0)
                    break;
                int count = deliveries[stack_delivery.peek()-1] - delivery_cap;
                if (count > 0) {
                    deliveries[stack_delivery.peek()-1] = count;
                    delivery_cap = 0;
                } else {
                    deliveries[stack_delivery.peek()-1] = 0;
                    delivery_cap = Math.abs(count);
                    stack_delivery.pop();
                }
            }
            answer += destination * 2L;
        }
        return answer;
    }
}