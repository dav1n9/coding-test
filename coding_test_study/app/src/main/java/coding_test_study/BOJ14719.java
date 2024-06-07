package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());  // h
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i < w-1; i++) {
            int left = 0;
            int right = 0;

            for(int l = 0; l < i; l++) {
                left = Math.max(arr[l], left);
            }
            for(int r = i+1; r < w; r++) {
                right = Math.max(arr[r], right);
            }

            if (arr[i] < left && arr[i] < right) {
                sum += Math.min(left, right) - arr[i];
            }
        }

        System.out.println(sum);
        
    }
}