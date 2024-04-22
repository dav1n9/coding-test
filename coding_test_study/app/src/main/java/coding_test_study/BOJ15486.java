package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n+1];
        int[] p = new int[n+1];
        
        // 입력받기
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+2];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);

            int next = i + t[i];
            if (next < n+2) 
                dp[next] = Math.max(dp[next], max + p[i]);
        }

        System.out.println(Math.max(max, dp[n+1]));
        br.close();
    }
}
