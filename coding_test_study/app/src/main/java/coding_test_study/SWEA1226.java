package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA1226 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int num = Integer.parseInt(br.readLine());

            int[][] board = new int[16][16];
            int[][] visited = new int[16][16];
            Queue<Point_1226> q = new LinkedList<>();

            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    board[i][j] = Integer.parseInt(str.charAt(j) + "");
                    if (board[i][j] == 2) {
                        q.add(new Point_1226(i, j));
                        visited[i][j] = 1;
                    }
                }
            }

            boolean isPos = false;
            while(!q.isEmpty()) {
                Point_1226 cur = q.poll();

                if (board[cur.x][cur.y] == 3) {
                    isPos = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
                    if (board[nx][ny] == 1 || visited[nx][ny] == 1) continue;

                    q.add(new Point_1226(nx, ny));
                    visited[nx][ny] = 1;
                }
            }

            if (isPos) System.out.println("#" + num + " " + 1);
            else System.out.println("#" + num + " " + 0);
        }

        br.close();
    }

    public static class Point_1226 {
        int x;
        int y;

        public Point_1226(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
