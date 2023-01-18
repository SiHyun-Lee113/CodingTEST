package com.example.coding_test.programmers;


import java.util.*;

public class divide_the_power_grid_in_two {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n, wires));
    }

    static int[][] arr;
    private static int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n][n];
        for(int i = 0; i < wires.length; i++) {
            arr[wires[i][0]-1][wires[i][1]-1] = 1;
            arr[wires[i][1]-1][wires[i][0]-1] = 1;
        }

        List<Integer> list = new ArrayList<>();
        int a, b;
        for(int i = 0; i < wires.length; i++) {
            a = wires[i][0]-1;
            b = wires[i][1]-1;

            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        return answer;
    }

    private static int bfs(int n, int start) {
        int[] visited = new int[n];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int point = queue.poll();
            visited[point] = 1;

            for(int i = 0; i < n; i++) {
                if (visited[i] == 1) continue;
                if(arr[point][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n - 2*cnt);
    }
}
