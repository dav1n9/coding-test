package bfs;

import java.util.*;

public class BOJ2178 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = input.next();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] distance = new int[n][m];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        // 탐색
        vis[0][0] = true;
        int curDistance = 1;
        distance[0][0] = curDistance;
        q.offer(new Point(0,0));

        while(!q.isEmpty()) {
            Point cur = q.peek();
            q.poll();
            curDistance = distance[cur.x][cur.y];

            for(int i = 0; i < 4; i++) {
                int curX = cur.x + dx[i];
                int curY = cur.y + dy[i];

                if(curX < 0 || curX >= n || curY < 0 || curY >= m) continue;
                if(board[curX][curY] != 1) continue;
                if(vis[curX][curY]) {
                    distance[curX][curY] = Math.min(distance[curX][curY], curDistance+1);
                } else {
                    vis[curX][curY] = true;
                    q.offer(new Point(curX, curY));
                    distance[curX][curY] = curDistance+1;
                }
            }
        }

        System.out.println(distance[n-1][m-1]);

        input.close();
    }
}