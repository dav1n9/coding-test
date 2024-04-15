package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] d = new int[1001];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] values = new int[n+1];
        for(int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(st.nextToken()); 
        }

        d[1] = 1;

        int max = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (values[j] < values[i]) {
                    d[i] = Math.max(d[i], d[j]+1);
                } else if (d[i] == 0) d[i]++;   // 이전 값들보다 작거나 같고, 부분수열이 자기 자신뿐일 떄.
            }
            if (d[i] > max) max = d[i];
        }

        System.out.println(max);

        br.close();
    }

}
