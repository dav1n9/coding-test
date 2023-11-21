package bfs;

import java.util.*;

public class BOJ10026 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = input.next();
            for (int c = 0; c < s.length(); c++) {
                board[i][c] = s.charAt(c);
            }
        }

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int resultR = 0;
        int resultB = 0;
        int resultG = 0;
        int check[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == 0 && board[i][j] == 'R') {
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    check[i][j] = 1;

                    while (!q.isEmpty()) {
                        Point cur = q.peek();
                        q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (board[nx][ny] == 'B' || board[nx][ny] == 'G' || check[nx][ny] == 1) continue;

                            q.add(new Point(nx, ny));
                            check[nx][ny] = 1;
                        }

                    }
                    resultR++;
                }
                if (check[i][j] == 0 && board[i][j] == 'G') {
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    check[i][j] = 1;

                    while (!q.isEmpty()) {
                        Point cur = q.peek();
                        q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (board[nx][ny] == 'B' || board[nx][ny] == 'R' || check[nx][ny] == 1) continue;

                            q.add(new Point(nx, ny));
                            check[nx][ny] = 1;
                        }

                    }
                    resultG++;
                }
                if (check[i][j] == 0 && board[i][j] == 'B') {
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    check[i][j] = 1;

                    while (!q.isEmpty()) {
                        Point cur = q.peek();
                        q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (board[nx][ny] == 'G' || board[nx][ny] == 'R' || check[nx][ny] == 1) continue;

                            q.add(new Point(nx, ny));
                            check[nx][ny] = 1;
                        }

                    }
                    resultB++;
                }
            }
        }

        int check2[][] = new int[n][n];
        int resultRG = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check2[i][j] == 0 && (board[i][j] == 'R' || board[i][j] == 'G')) {
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    check2[i][j] = 1;

                    while (!q.isEmpty()) {
                        Point cur = q.peek();
                        q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (board[nx][ny] == 'B'|| check2[nx][ny] == 1) continue;

                            q.add(new Point(nx, ny));
                            check2[nx][ny] = 1;
                        }

                    }
                    resultRG++;
                }
            }
        }
        System.out.println((resultR+resultG+resultB) + " " + (resultRG+resultB));

        input.close();
    }
}
