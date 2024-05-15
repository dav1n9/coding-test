package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA2817 {

    static int n;
    static int k;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            // 모든 조합 따져서 합이 k가 되는 경우 찾기
            dfs(0, 0);

            System.out.println("#" + t + " " + ans);

        }

        br.close();
    }

    public static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum == k) {
                ans++;
            }
            return;
        }

        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}
