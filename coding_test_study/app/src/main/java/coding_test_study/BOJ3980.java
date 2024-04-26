package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ3980 {

    static int[][] arr;
    static int[] checked;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            arr = new int[11][11];
            checked = new int[11]; // 각 포지션에 선수가 채워졌는지 확인
            result = 0;

            for(int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 최대 능력치 합 구하기
            dfs(0, 0);
            System.out.println(result);

        }

        br.close();
    }

    public static void dfs(int idx, int sum) {
        if (idx == 11) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (arr[idx][i] > 0 && checked[i] == 0) {
                checked[i] = 1;
                dfs(idx+1, sum + arr[idx][i]);
                checked[i] = 0;
            }
            
        }
    }
}
