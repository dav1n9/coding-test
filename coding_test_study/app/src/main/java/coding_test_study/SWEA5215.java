package coding_test_study;

import java.util.*;
import java.io.*;

public class SWEA5215 {
    static int n, l;
    static int[] score;
    static int[] kcal;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());  // 재료 수
            l = Integer.parseInt(st.nextToken());  // 제한 칼로리

            score = new int[n];
            kcal = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;

            dfs(0, 0, 0);
            
            System.out.println("#" + t + " " + ans);

        }

        br.close();
    }

    // cur_count가 count가 될때까지 반복
    public static void dfs(int cur_count, int kcal_sum, int score_sum) {
        if (cur_count == n) {
            if (kcal_sum <= l) {
                ans = Math.max(ans, score_sum);
            }
            return;
        }

        dfs(cur_count+1, kcal_sum + kcal[cur_count], score_sum + score[cur_count]);
        dfs(cur_count+1, kcal_sum, score_sum);
    }
}
