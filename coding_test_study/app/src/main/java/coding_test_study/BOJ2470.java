package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;        // 포인트1
        int p2 = n-1;      // 포인트2

        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        Arrays.sort(arr);

        while (p2 - p1 > 0) {
            int temp = arr[p2] + arr[p1];
            
            if (min > Math.abs(temp)) {     // 두 포인트의 합의 절대값과 비교.
                min = Math.abs(temp);
                ans1 = p1;
                ans2 = p2;
            }

            if (temp > 0) p2--;
            else p1++;
        }

        System.out.println(arr[ans1] + " " + arr[ans2]);

        br.close();
    }
}
