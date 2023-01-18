package com.example.coding_test.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최대공약수 GCD : Greatest Common Division
 * 최소공배수 LCM : The Least Common Multiple
 * */
public class GCD_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        System.out.println(Arrays.toString(solution(n, m)));
    }

    private static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a;
        int b;

        a = Math.max(n, m);
        b = Math.min(n, m);

        int r = a%b;
        int q = a/b;
        if(r == 0) {
            answer[0] = b;
        }
        else {
            System.out.println(r);
            while(r > 0) {
                int r1 = a % b;
                System.out.println(r1);
                if(r1 == 0) {
                    answer[0] = b;
                    break;
                } else {
                    a = b;
                    b = r1;
                }
            }
        }//d
        answer[1] = n*m / answer[0];

        return answer;
    }
}
