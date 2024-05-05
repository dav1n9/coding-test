package coding_test_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1954 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][n];
            board[0][0] = 1;

            int d = 0; // 방향
            int nx = 0;
            int ny = 0;
            int count = 2;

            while (count <= n*n) {

                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] > 0) {
                    nx -= dx[d];
                    ny -= dy[d];
                    d++;
                    d %= 4;
                } else {
                    board[nx][ny] = count++;
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        br.close();
    }
}
