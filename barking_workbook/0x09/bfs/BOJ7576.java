package bfs;

import java.util.*;

public class BOJ7576 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();

        Queue<Point> q = new LinkedList<>();
        int redTomatos[][] = new int[n][m];
        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };

        int board[][] = new int[n][m];

        boolean possible = false;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = input.nextInt();
                if (board[i][j] == 1) {
                    redTomatos[i][j] = 1;
                    q.offer(new Point(i, j));
                } else if (board[i][j] == -1) {
                    redTomatos[i][j] = 1;
                } else { // 0이면
                    redTomatos[i][j] = 0;
                    possible = true;
                    zeroCount++;
                }
            }
        }

        int max = 0;
        if (possible) {
            while (!q.isEmpty()) {
                Point cur = q.peek();
                q.poll();
                int count = redTomatos[cur.x][cur.y];
                for (int i = 0; i < 4; i++) {
                    int curX = cur.x + dx[i];
                    int curY = cur.y + dy[i];

                    if (curX < 0 || curX >= n || curY < 0 || curY >= m)
                        continue;
                    if (redTomatos[curX][curY] != 0 || board[curX][curY] != 0)
                        continue;

                    redTomatos[curX][curY] = count + 1;
                    max = Math.max(max, redTomatos[curX][curY]);
                    q.offer(new Point(curX, curY));
                    zeroCount--;
                }
            }

            if(zeroCount == 0)
                System.out.println(max - 1);
            else
                System.out.println("-1");

        } else {
            System.out.println("0");
        }

        input.close();
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
