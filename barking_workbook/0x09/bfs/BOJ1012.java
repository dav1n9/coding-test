package bfs;

import java.util.*;

public class BOJ1012 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<int[][]> boardList = new LinkedList<>();

        int testCase = input.nextInt();
        for (int i = 0; i < testCase; i++) {

            int m = input.nextInt();
            int n = input.nextInt();
            int[][] board = new int[m][n];
            int k = input.nextInt();
            for (int j = 0; j < k; j++) {
                int x = input.nextInt();
                int y = input.nextInt();
                board[x][y] = 1;
            }
            boardList.add(board);
        }

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int i = 0; i < testCase; i++) {
            int result = 0; // 필요한 지렁이 수
            int[][] boardEach = boardList.get(i);
            int[][] check = new int[boardEach.length][boardEach[0].length];
            for (int x = 0; x < boardEach.length; x++) {
                for (int y = 0; y < boardEach[0].length; y++) {
                    Queue<Point> q = new LinkedList<>();
                    if (boardEach[x][y] == 1 && check[x][y] == 0) {
                        q.add(new Point(x, y));
                        check[x][y] = 0;

                        while (!q.isEmpty()) {
                            Point cur = q.peek();
                            q.poll();

                            for (int j = 0; j < 4; j++) {
                                int nx = cur.x + dx[j];
                                int ny = cur.y + dy[j];

                                if (nx < 0 || nx > boardEach.length-1 || ny < 0 || ny > boardEach[0].length-1)
                                    continue;
                                if (boardEach[nx][ny] == 0 || check[nx][ny] == 1)
                                    continue;

                                q.add(new Point(nx, ny));
                                check[nx][ny] = 1;
                            }

                        }
                        result++;
                    }

                }
            }
            System.out.println(result);
        }

        input.close();
    }
}
