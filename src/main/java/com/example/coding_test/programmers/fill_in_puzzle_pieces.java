package com.example.coding_test.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class fill_in_puzzle_pieces {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    static List<List<Node>> resultForGameBoard = new ArrayList<>();
    static List<List<Node>> resultForTable = new ArrayList<>();

    static boolean[][] check2;
    static boolean[][] check;

    public static List<Node> bfs_for_game_board(Node start, int[][] board) {
        List<Node> one_piece_of_puzzle = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        check[start.getX()][start.getY()] = true;
        board[start.getX()][start.getY()] = 1;
        queue.add(start);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            one_piece_of_puzzle.add(node);
            int cx = node.x;
            int cy = node.y;

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx > board.length - 1 || ny < 0 || ny > board.length - 1) {
                    continue;
                }
                if(!check[nx][ny] && board[nx][ny] == 0) {
                    Node node1 = new Node();
                    node1.setX(nx);
                    node1.setY(ny);
                    check[nx][ny] = true;

                    queue.add(node1);
                }
            }
        }
        one_piece_of_puzzle = sort(one_piece_of_puzzle);
        return one_piece_of_puzzle;
    }
    public static List<Node> bfs_for_table(Node start, int[][] board) {
        List<Node> one_piece_of_puzzle = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        check2[start.getX()][start.getY()] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            one_piece_of_puzzle.add(node);
            int cx = node.x;
            int cy = node.y;

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx > board.length - 1 || ny < 0 || ny > board.length - 1) {
                    continue;
                }
                if(!check2[nx][ny] && board[nx][ny] == 1) {
                    Node node1 = new Node();
                    node1.setX(nx);
                    node1.setY(ny);
                    check2[nx][ny] = true;

                    queue.add(node1);
                }
            }
        }
        one_piece_of_puzzle = sort(one_piece_of_puzzle);
        return one_piece_of_puzzle;
    }

    public static List<Node> sort(List<Node> list) {
        List<Node> sorted = new ArrayList<>();

        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;

        for(Node l : list) {
            if(l.getX() < xMin)
                xMin = l.getX();
            if(l.getY() < yMin)
                yMin = l.getY();
        }

        for(Node l : list) {
            Node sort_node = new Node();

            sort_node.setX(l.getX() - xMin);
            sort_node.setY(l.getY() - yMin);

            sorted.add(sort_node);
        }

        return sorted;
    }
    public static List<Node> passed_puzzle_spin(List<Node> passed_puzzle) {
        int[] x = {0, 0, 0, 0, 0, 0};
        int[] y = {0, 0, 0, 0, 0, 0};

        for(Node n : passed_puzzle) {
            x[n.getX()]++;
            y[n.getY()]++;
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int max = 0;
        if(x[5] >= y[5]) {
            max = x[5];
        } else {
            max = y[5];
        }
        List<Node> spined = new ArrayList<>();

        for(Node n : passed_puzzle) {
            Node sp = new Node();
            sp.setX(max- n.getY() - 1);
            sp.setY(n.getX());

            spined.add(sp);
        }
        return spined;
    }

    public static int final_check(List<Node> game_board, List<Node> table) {
        int game_board_size = game_board.size();
        int table_size = table.size();

        if (game_board.isEmpty() || table.isEmpty()) {
            return 0;
        }

        if(game_board_size != table_size)
            return -1;

        int pass = 0;
        for(int i = 0; i < game_board.size(); i++) {
            for(int j = 0; j < game_board_size; j++) {
                if((game_board.get(i).getX() == table.get(j).getX()) &&
                        (game_board.get(i).getY() == table.get(j).getY())) {
                    pass++;
                }
            }
        }
        if(pass == game_board_size) {
            return game_board_size;
        }else {
            return 0;
        }
    }

    public static int solution2() {
        int answer = 0;
        boolean pass = false;
        for(int i = 0; i <resultForTable.size(); i++) {
            for(List<Node> game : resultForGameBoard) {
                int index_of_g = resultForGameBoard.indexOf(game);
                if(final_check(resultForTable.get(i), game) > 0) {
                    answer += final_check(resultForTable.get(i), game);
                    resultForGameBoard.remove(index_of_g);
                    pass = true;
                    break;
                }
            }
            if(pass) {

                resultForTable.remove(i);
                pass = false;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int[][] game_board = new int[3][3];
        int[][] table = new int[6][6];

        for(int i = 0; i < 3; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                game_board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
//d
        for(int i = 0; i < 3; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        check = new boolean[game_board.length][game_board.length];

        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board.length; j++) {
                Node start = new Node();
                start.setX(i);
                start.setY(j);
                if(!check[i][j] && game_board[i][j] == 0) {
                    resultForGameBoard.add(bfs_for_game_board(start, game_board));
                    check[i][j] = true;
                }
                check[i][j] = true;
            }
        }
        int result = 0;

        check2 = new boolean[table.length][table.length];
        resultForTable = new ArrayList<>();
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                Node start = new Node();
                start.setX(i);
                start.setY(j);
                if(!check2[i][j] && table[i][j] == 1) {
                    resultForTable.add(bfs_for_table(start, table));
                    check2[i][j] = true;
                }
                check2[i][j] = true;
            }
        }

        for(int i = 0; i < 4; i++) {
            List<List<Node>> spin = new ArrayList<>();

            for(List<Node> l : resultForTable) {
                spin.add(sort(passed_puzzle_spin(l)));
            }
            resultForTable.clear();
            resultForTable = spin;
            result += solution2();
        }

        System.out.println(result);
        System.out.println("end");
    }
    public static class Node {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
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
