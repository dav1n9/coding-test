package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ1520 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int[][] dp;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        dp = new int[m][n];   // (x, y)에서 도착점으로 가는 경로의 개수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));

        br.close();
    }

    public static int dfs(int x, int y ) {
        if (x == m-1 && y == n-1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (arr[x][y] <= arr[nx][ny]) continue;

            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }

}
