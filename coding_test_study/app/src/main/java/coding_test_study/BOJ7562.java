package coding_test_study;

import java.util.*;
import java.io.*;

public class BOJ7562 {

    static int size;
    static int[][] board;
    static int[][] isVisited;
    static int[] dx = {-2, -1, 2, 1, -2, -1, 2, 1};
    static int[] dy = {-1, -2, -1, -2, 1, 2, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];
            isVisited = new int[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());

            bfs(new Point7562(startX, startY), new Point7562(destX, destY));

            System.out.println(board[destX][destY]);
        }

        br.close();
    }

    public static void bfs(Point7562 start, Point7562 dest) {
        Queue<Point7562> q = new LinkedList<>();
        q.add(start);
        isVisited[start.x][start.y] = 1;

        while(!q.isEmpty()) {
            Point7562 cur = q.poll();

            if (cur == dest) break;

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                if (isVisited[nx][ny] == 1) continue;

                q.add(new Point7562(nx, ny));
                isVisited[nx][ny] = 1;
                board[nx][ny] = board[cur.x][cur.y] + 1;
            }
        }

    }

    public static class Point7562 {
        int x;
        int y;

        Point7562(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
