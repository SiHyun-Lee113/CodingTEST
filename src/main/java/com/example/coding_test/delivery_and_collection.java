package com.example.coding_test;

import java.util.*;

public class delivery_and_collection {
    public static void main(String[] args) throws InterruptedException {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
//        int cap = 17;
//        int n = 100000;
//        int[] deliveries = new int[100000];
//        int[] pickups = new int[100000];
//        for(int i = 0; i < deliveries.length; i++) {
//            deliveries[i] = 50;
//            pickups[i] = 50;
//        }
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

    public static int solution(int cap, int n, int[] deliveries, int[] pickups) throws InterruptedException {
        int answer = 0;

        List<Delivery> deliveryList = new ArrayList<>();
        boolean[] delivery_check = new boolean[deliveries.length];
        boolean[] pickup_check = new boolean[pickups.length];

        for(int i = 0; i < n; i++) {
            boolean remaining_receive = deliveries[i] > 0;
            boolean remaining_send = pickups[i] > 0;

            delivery_check[i] = remaining_receive;
            pickup_check[i] = remaining_send;

            Delivery delivery = new Delivery(deliveries[i], pickups[i]);
            deliveryList.add(delivery);
        }

        int delivery_cap = 0;
        int destination = 0;
        while(!deliveryList.isEmpty()) {

            destination = Math.max(max_length(delivery_check), max_length(pickup_check));
            if (destination == 0)
                break;

            delivery_cap = cap;
            for(int i = destination - 1; i >= 0; i--) {

                if (delivery_cap == 0) {
                    break;
                }
                if (!delivery_check[i])
                    continue;
                int count = deliveryList.get(i).receive - delivery_cap;
                if (count > 0) {
                    deliveryList.get(i).receive = count;
                    delivery_cap = 0;
                } else {
                    deliveryList.get(i).receive = 0;
                    delivery_check[i] = false;
                    delivery_cap = Math.abs(count);

                }
            }

            int pickup_cap = cap;
            for(int i = destination - 1; i >= 0; i--) {

                if (pickup_cap == 0) {
                    break;
                }
                if (!pickup_check[i])
                    continue;
                int count = deliveryList.get(i).send - pickup_cap;
                if (count > 0) {
                    deliveryList.get(i).send = count;
                    pickup_cap = 0;
                } else {
                    deliveryList.get(i).send = 0;
                    pickup_check[i] = false;
                    pickup_cap = Math.abs(count);
                }
            }
//            for(int i = destination - 1; i >= 0; i--) {
//                if (pickup_cap >= cap) {
//                    break;
//                }
//                if (!pickup_check[i])
//                    continue;
//
//                int send = deliveryList.get(i).send;
//                pickup_cap += send;
//                if (pickup_cap > cap) {
//                    int abs = pickup_cap - cap;
//                    pickup_cap = cap;
//                    deliveryList.get(i).send = abs;
//                    if (deliveryList.get(i).send == 0)
//                        pickup_check[i] = false;
//                } else {
//                    deliveryList.get(i).send -= send;
//                    if (deliveryList.get(i).send == 0)
//                        pickup_check[i] = false;
//                }
//            }
            for(int i = destination-1; i >= 0; i--) {
                if (!delivery_check[i] && !pickup_check[i]) {
                    deliveryList.remove(i);
                }
                else {
                    break;
                }
            }

            answer += destination * 2;

        }
        return answer;
    }
    public static int max_length(boolean[] remaining) {
        int length = 0;

        for(int i = remaining.length -1; i >= 0; i--) {
            if (remaining[i])
                return i+1;
        }

        return length;
    }

    static class Delivery {
        int receive;
        int send;

        public Delivery(int receive, int send) {
            this.receive = receive;
            this.send = send;
        }

        @Override
        public String toString() {
            return "Delivery{" +
                    "receive=" + receive +
                    ", send=" + send +
                    '}';
        }
    }
}

// System.out.println(Arrays.toString(delivery_check));
//            System.out.println(Arrays.toString(pickup_check));
//            System.out.println(destination);
//            System.out.println("------------------------------");
