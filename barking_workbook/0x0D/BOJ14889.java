import java.util.Arrays;
import java.util.Scanner;

public class BOJ14889 {

    static int n;
    static int[][] board;

    static int[] numbers;
    static int[] isused;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. 입력받기
        n = input.nextInt();
        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = input.nextInt();
            }
        }

        numbers = new int[n/2 + 1];
        isused = new int[21];
        Arrays.fill(isused, 0);

        fun(0, 0);
        System.out.println(answer);

        input.close();
    }

    // 두 팀으로 나누고, 능력치 구하기
    static void fun(int k, int m) {
        if(k == n/2) {
            // 두명씩 뽑아 능력치 더하기
            // isused 에서 true 인팀과 false 인팀으로 나누면 될 듯.
            int start = 0;
            int link = 0;
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    int cnt = isused[i] + isused[j];
                    if(cnt == 2) { // true, true  인 경우
                        start += board[i][j] + board[j][i];
                    } else if(cnt == 0) { // false, false 인 경우
                        link += board[i][j] + board[j][i];
                    }
                }
            }
            int start_link = Math.abs(start-link);

            // 최소값 저장
            if (start_link < answer)
                answer = start_link;
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(isused[i-1] == 0 && i > m) {
                numbers[k] = i;
                isused[i-1] = 1;
                fun(k+1, i);
                isused[i-1] = 0;
            }
        }

    }

}
