package bfs;

import java.util.*;

// 실패 -해결필요..

public class BOJ4179 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int R = input.nextInt();
        int C = input.nextInt();

        Character board[][] = new Character[R][C];
        Queue<Point> fQueue = new LinkedList<>();
        Queue<Point> jQueue = new LinkedList<>();
        int fire[][] = new int[R][C];
        int jihun[][] = new int[R][C];

        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };

        for (int i = 0; i < R; i++) {
            String s = input.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'F') {
                    fQueue.offer(new Point(i, j));
                    fire[i][j] = 0;
                } else if (board[i][j] == 'J' || board[i][j] == '.') {
                    fire[i][j] = -1;
                }

                if (board[i][j] == 'J') {
                    jQueue.offer(new Point(i, j));
                    jihun[i][j] = 0;
                } else if (board[i][j] == 'F' || board[i][j] == '.') {
                    jihun[i][j] = -1;
                }
            }
        }

        // 일단 불에 대한 시간구하기
        while (!fQueue.isEmpty()) {
            Point cur = fQueue.peek();
            fQueue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                    continue;
                if (fire[nx][ny] >= 0 || board[nx][ny] == '#')
                    continue;

                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                fQueue.offer(new Point(nx, ny));
            }
        }
        
        int result = 0;
        // 일단 지훈에 대한 시간구하기
        while (!jQueue.isEmpty()) {
            Point cur = jQueue.peek();
            jQueue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) { // 탈출
                    result = jihun[cur.x][cur.y] + 1;
                    jQueue.clear();
                    continue;
                }

                if (jihun[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                if (fire[nx][ny] != -1 && fire[nx][ny] <= jihun[cur.x][cur.y]+1) continue;

                jihun[nx][ny] = jihun[cur.x][cur.y] + 1;
                jQueue.offer(new Point(nx, ny));
            }
        }

        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println("IMPOSSIBLE");
        }

        input.close();
    }
}
