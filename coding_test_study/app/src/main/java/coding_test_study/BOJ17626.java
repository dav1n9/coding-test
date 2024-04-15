package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] d = new int[50001];
        Arrays.fill(d, 4);  // 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다. 최대값인 4로 초기화한다.

        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            
            for(int j = 1; j*j <= i; j++) {
                d[i] = Math.min(d[i - j * j], d[i]);
            }
            d[i] += 1;
        }

        System.out.println(d[n]);

        br.close();
    }
}
