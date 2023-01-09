package com.example.coding_test;

import java.util.*;

public class Valid_period {
    public static void main(String[] args) {
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};



        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            for (String term : terms) {
                StringTokenizer stk = new StringTokenizer(term, " ");
                if (privacies[i].charAt(11) == stk.nextToken().charAt(0))
                    if (check(privacies[i], stk.nextToken(), today)) {
                        list.add(i+1);
                    }
            }
        }

        int[] answer;
        answer = list.stream().mapToInt(n->n).toArray();

        return answer;
    }

    private static boolean check(String privacy, String term, String today) {

        int year = Integer.parseInt(privacy.substring(0, 4));
        int month = Integer.parseInt(privacy.substring(5, 7)) + Integer.parseInt(term);
        int day = Integer.parseInt(privacy.substring(8, 10)) - 1;

        if (day < 1) {
            month--;
            day = 28;
        }
        if (day > 28) {
            month++;
            day -= 27;
        }
        if (month > 12) {
            year++;
            month -= 12;
        }
        if (month < 1) {
            year--;
            month = 12;
        }

        int today_year = Integer.parseInt(today.substring(0, 4));
        int today_month = Integer.parseInt(today.substring(5, 7));
        int today_day = Integer.parseInt(today.substring(8, 10));

        Date date1 = new Date(today_year, today_month, today_day);
        Date date2 = new Date(year, month, day);
        return date2.before(date1);
    }

}
