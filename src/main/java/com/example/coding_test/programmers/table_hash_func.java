package com.example.coding_test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class table_hash_func  {
    public static void main(String[] args) {
        int[][] data = {{2,2,6,7},{1,5,10,11},{4,2,9,4},{3,8,3,56}};
        int col = 2;
        int row_begin = 2;
        int row_end = 4;

        System.out.println(solution(data, col, row_begin, row_end));
    }

    private static int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        int answer = 0;

        Arrays.sort(data,
                (o1, o2) -> {
            return (o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);});
        System.out.println(Arrays.deepToString(data));
        List<Integer> modList = new ArrayList<>();

        for(int i = rowBegin; i <=rowEnd; i++) {
            modList.add(get_mod(data[i-1], i));
        }
        System.out.println("modList = " + modList);

        for (int xor : modList) {
            answer = answer ^ xor;
        }

        return answer;
    }

    private static int get_mod(int[] data, int i) {
        int mod = 0;
        for (int datum : data) {
            mod += datum % i;
            System.out.println(datum % i);
        }
        System.out.println();

        return mod;
    }
}

/**
 * [2,  2,  6],
 * [1,  5,  10],
 * [4,  2,  9],
 * [3,  8,  3]
 *          mod
 * 4 2 9
 * 2 2 6
 * 1 5 10
 * 3 8 3
 * */