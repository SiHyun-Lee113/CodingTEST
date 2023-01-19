package com.example.coding_test.programmers_level3;

import java.util.*;

public class BaseStationInstallation {
    public static void main(String[] args) {
        int N = 30;
        int[] stations = {29};
        int W = 2;

        System.out.println(solution(N, stations, W));
    }

    static public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int[][] fill_info = new int[stations.length+1][2];

        for (int i = 0; i < stations.length; i++) {
            int left = stations[i] - w - 1;
            int right = stations[i] + w + 1;
            fill_info[i][1] = left;
            fill_info[i+1][0] = right;
        }
        fill_info[stations.length][1] = n;

        for (int[] ints : fill_info) {
            System.out.println(Arrays.toString(ints));
        }

        int connection_area = 1 + w * 2;
        for (int[] ints : fill_info) {
            int fill_area = ints[1] - ints[0]+1;
            if (fill_area > 0) {
                if (fill_area % connection_area == 0) {
                    answer += fill_area / connection_area;
                }
                else {
                    answer += (fill_area / connection_area) + 1;
                }
            }
        }

        return answer;
    }
}
