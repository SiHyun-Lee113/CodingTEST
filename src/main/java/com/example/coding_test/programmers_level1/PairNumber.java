package com.example.coding_test.programmers_level1;

import java.util.*;

public class PairNumber {
    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";

        System.out.println(solution(X, Y));

    }

    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = {0,0,0,0,0,0,0,0,0,0};
        int[] y = {0,0,0,0,0,0,0,0,0,0};
        for(int i=0; i<X.length();i++){
            x[X.charAt(i)-48] += 1;
        }
        for(int i=0; i<Y.length();i++){
            y[Y.charAt(i)-48] += 1;
        }

        for(int i=9; i >= 0; i--){
            for(int j=0; j<Math.min(x[i],y[i]); j++){
                answer.append(i);
            }
        }
        if("".equals(answer.toString())){
            return "-1";
        }else if(answer.toString().charAt(0)==48){
            return "0";
        }else {
            return answer.toString();
        }
    }
}
