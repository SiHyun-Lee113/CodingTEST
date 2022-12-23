package com.example.coding_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class create_a_star_at_the_node {

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
//        int[][] line = {{1, -1, 0}, {2, -1, 0}};
        String[] result = solution(line);

        for (String s : result) {
            System.out.println(s);
        }
    }
    static List<Node> meet_point = new ArrayList<>();
    static long minX = Long.MAX_VALUE;
    static long minY = Long.MAX_VALUE;
    static long maxX = Long.MIN_VALUE;
    static long maxY = Long.MIN_VALUE;

    public static String[] solution(int[][] line) {
        String[] answer = {};
        for(int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                meet(line[i], line[j]);
            }
        }

        for (Node node : meet_point) {
            System.out.println("node = " + node);
        }

        min_max(meet_point);

        int height = (int) (maxY - minY +1);
        int width = (int) (maxX - minX + 1);

        String[] result_one = new String[height];
        boolean[][] board = new boolean[height][width];

        for (Node point : meet_point) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);

            board[y][x] = true;
        }


        int i = 0;
        for (boolean[] booleans : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : booleans) {
                if (b) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            result_one[i++] = sb.toString();
        }
        return result_one;
    }

    public static void min_max(List<Node> nodes) {
        for(Node n : nodes) {
            minX = (int)Math.min(minX, n.x);
            minY = (int)Math.min(minY, n.y);
            maxX = (int)Math.max(maxX, n.x);
            maxY = (int)Math.max(maxY, n.y);
        }
    }

    public static void meet(int[] A, int[] B) {
        long a = A[0];
        long b = A[1];
        long c = B[0];
        long d = B[1];
        long e = A[2];
        long f = B[2];

        long denominator = a * d - b * c;
        if (denominator == 0) {
            return;
        }

        long xNumerator = b * f - e * d;
        long yNumerator = e * c - a * f;

        if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
            return;
        }

        long x = xNumerator / denominator;
        long y = yNumerator / denominator;

        meet_point.add(new Node((int)x, (int)y));
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
