package coding_test_study;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][n];
            // 스티커 값 저장
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[2][n];
            d[0][0] = stickers[0][0];
            d[1][0] = stickers[1][0];
            
            if (n > 1) {
                d[0][1] = stickers[0][1] + stickers[1][0];
                d[1][1] = stickers[1][1] + stickers[0][0];
            }

            for (int i = 2; i < n; i++) {
                // 0번째 행, i번째 열 값 갱신
                d[0][i] = Math.max(d[1][i-2], d[1][i-1]) + stickers[0][i];

                // 1번째 행, i번째 열 값 갱신
                d[1][i] = Math.max(d[0][i-2], d[0][i-1]) + stickers[1][i];
            }

            System.out.println(Math.max(d[0][n-1], d[1][n-1]));
        }

        br.close();
    }
}
