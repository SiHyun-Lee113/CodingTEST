package com.example.coding_test.programmers_level3;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "gay"};
        int[] plays = {500, 2500, 150, 800, 2500, 23};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    /**
     * classic 1900
     * pop 3100
     * */
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        List<Album> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            list.add(new Album(genres[i], i, plays[i]));
        }
        Collections.sort(list, (o1, o2) -> {
            // 장르가 같으면 플레이수로 비교
            if (o1.genres.equals(o2.genres))
                return o2.plays - o1.plays;
                // 장르도 같고 플레이수도 같으면 인덱스가 빠른순으로 정렬
            else if (o1.genres.equals(o2.genres) && o1.plays == o2.plays)
                return o1.index - o2.index;
            else
                return o1.genres.compareTo(o2.genres);
        });

        HashMap<String, Integer> genresLank = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            try {
                int value = genresLank.get(key) + plays[i];
                genresLank.put(key, value);
            } catch (NullPointerException e) {
                int value = plays[i];
                genresLank.put(key, value);
            }
        }

        List<Integer> result = new ArrayList<>();
        // 장르 랭킹 설정
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genresLank.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int index = 0;
        int count;
        for(Map.Entry<String, Integer> entry : entryList){
            count = 0;
            for (Album album : list) {
                if (album.genres.equals(entry.getKey()) && count < 2) {
                    result.add(album.index);
                    index++;
                    count++;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static public class Album {
        String genres;
        int index;
        int plays;

        public Album(String genres, int index, int plays) {
            this.genres = genres;
            this.index = index;
            this.plays = plays;
        }
    }
}
