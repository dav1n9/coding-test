package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] board = new int[h+1][w+1];      // 누적합 배열

        for(int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= w; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num + board[i][j-1] + board[i-1][j] - board[i-1][j-1];
            }
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1];
            System.out.println(result);
        }

        br.close();
    }
}
