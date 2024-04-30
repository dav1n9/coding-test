package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA3752 {
    static int n;
    static int[] arr;
    static int[][] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            visited = new int[n+1][sum+1];
            list = new ArrayList<>();
            // 가능한 점수의 경우의 수
            dfs(0, 0);
            System.out.println("#" + testCase + " " + list.size());
        }

        br.close();
    }

    public static void dfs(int idx, int sum) {
        if (idx == n) {
            if (!list.contains(sum)) {
                list.add(sum);
                // System.out.println(sum);
            }
            return;
        }

        if (visited[idx][sum] > 0) return;
        visited[idx][sum] = 1;

        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}
