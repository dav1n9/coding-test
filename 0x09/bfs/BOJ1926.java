package bfs;

import java.util.*;

public class BOJ1926 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // 입력 받기
        int n = input.nextInt();
        int m = input.nextInt();

        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        boolean vis[][] = new boolean[n][m];    // 방문여부 정보 담을 vis
        Queue<Point> qu = new LinkedList<>(); // 1인 지역 담을 큐
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        int maxSize = 0;

        // 처음 (0,0)부터 방문
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                
                if(vis[i][j] || arr[i][j] == 0) { continue; }

                vis[i][j] = true;
                qu.offer(new Point(i, j));
                int size = 1;

                while(!qu.isEmpty()) {
                    
                    Point cur = qu.peek();
                    qu.poll();

                    for(int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || arr[nx][ny] != 1) continue;
        
                        vis[nx][ny] = true;
                        qu.offer(new Point(nx, ny));
                        size++;
                    }
                }
                count++;
                if(maxSize < size) {
                    maxSize = size;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);

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