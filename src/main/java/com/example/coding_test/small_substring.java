package com.example.coding_test;

public class small_substring {
    public static void main(String[] args) {
        String t = "3141592";
        String p = "3141592";

        System.out.println(solution(t, p));
    }

    private static int solution(String t, String p) {
        int answer = 0;
        long P = Long.parseLong(p);

        for(int i = 0; i <= t.length()-p.length(); i++) {
            long T = Long.parseLong(t.substring(i, i+p.length()));

            if(T <= P)
                answer++;
        }

        return answer;
    }
}
