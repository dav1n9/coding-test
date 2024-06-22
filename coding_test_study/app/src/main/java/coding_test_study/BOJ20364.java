package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ20364 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            int idx = x; // 나중에 할당할수도있으니까 따로 저장.

            int result = arr[x] > 0 ? x : 0;
            while(x > 0) {
                x = (x % 2 == 0) ? x / 2 : (x - 1) / 2;
                
                if (arr[x] > 0) result = x;
            }
            if (result == 0) arr[idx]++;
            System.out.println(result);
        }



        br.close();
    }
}
