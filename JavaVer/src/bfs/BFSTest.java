package bfs;

import java.util.*;

public class BFSTest {
    public static void main(String[] args) throws Exception {

        int board[][] ={{1,1,1,0,1,0,0,0,0,0},
                        {1,0,0,0,1,0,0,0,0,0},
                        {1,1,1,0,1,0,0,0,0,0},
                        {1,1,0,0,1,0,0,0,0,0},
                        {0,1,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0} }; // 1이 파란 칸, 0이 빨간 칸에 대응
        int n = 7, m = 10; // n = 행의 수, m = 열의 수

        boolean vis[][] = new boolean[502][502];
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        vis[0][0] = true;
        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {
            Point cur = q.peek();
            q.poll();
            System.out.println("(" + cur.x + ", " + cur.y + ") => ");

            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] || board[nx][ny] != 1) continue;

                vis[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }
}


class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}