package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int len = 0;

        for (int end = 0; end < n; end++) {
            if (map.containsKey(arr[end])){
                map.put(arr[end], map.get(arr[end]) + 1);
                len++;

                if (map.get(arr[end]) > k) {
                    while (map.get(arr[end]) > k) {
                        map.put(arr[start], map.get(arr[start]) - 1);
                        start++;
                        len--;
                    }
                    continue;
                }
                
            } else {
                map.put(arr[end], 1);
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        System.out.println(maxLen);

        br.close();
        
    }
}
