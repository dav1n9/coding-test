package coding_test_study;

import java.io.*;

public class SWEA17299 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test_case; t++) {
            String num = br.readLine();
            int min = Integer.MAX_VALUE;

            for (int i = 1; i < num.length(); i++) {
                int n1 = Integer.parseInt(num.substring(0, i));
                int n2 = Integer.parseInt(num.substring(i));
                min = Math.min(min, n1 + n2);
            }
            System.out.println("#" + t + " " + min);
        }

        br.close();
    }
}
