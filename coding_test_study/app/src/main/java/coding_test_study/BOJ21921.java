package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ21921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1; // 시작일
        int max = 0;   // 최대 방문자 수
        for (int i = 0; i < x; i++) max += arr[i];
        int temp = max;

        int count = 1;

        for (int end = x; end < n; end++) {
            temp = temp - arr[start-1] + arr[end];

            if (temp == max) count++;
            else if (temp > max) {
                max = temp;
                count = 1;
            }
            start++;
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }

        br.close();
    }
}
