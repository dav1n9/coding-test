package coding_test_study;

import java.util.Scanner;

public class SWEA1220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt(); // 항상 100
            int[][] board = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int ans = 0;
            boolean find2 = false;
            // 1은 아래로 2는 위로..
            for (int i = 0; i < n; i++) {
                // board[][i] 에서 1다음에 2나오면 +1
                find2 = false;
                for(int j = 0; j < n; j++) {
                    if (board[j][i] == 1) find2 = true;
                    else if (find2 && board[j][i] == 2) {
                        ans++;
                        find2 = false;
                    }
                }
            }
            System.out.println(ans);
        }

        sc.close();
    }
}