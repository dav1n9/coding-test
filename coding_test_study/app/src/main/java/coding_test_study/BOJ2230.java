package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ2230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while(start < (n-1) || end < (n-1)) {
            if (start <= end && arr[end] - arr[start] >= m) {
                min = Math.min(arr[end] - arr[start], min);
                start++;
            } else if (end < n-1){
                end++;
            } else {
                break;
            }
        }
        System.out.println(min);

        br.close();
    }
}
