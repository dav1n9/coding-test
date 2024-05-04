package coding_test_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test_case; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] board = new int[m][m];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i <= (m - n); i++) {
                for (int j = 0; j <= (m - n); j++) {
                    max = Math.max(max, sum(i, j, n, board));
                }
            }

            System.out.println("#" + t + " " + max);
        }

        br.close();
    }

    public static int sum (int x, int y, int n, int[][] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[x+i][y+j];
            }
        }
        return sum;
    }
}
