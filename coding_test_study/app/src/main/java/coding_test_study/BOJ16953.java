package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 1;
        while (true) {
            if (b == a) {
                System.out.println(count);
                break;
            } else if (b < a) {
                System.out.println(-1);
                break;
            }

            if (b % 10 == 1) {
                b /= 10;
                count++;
            } else if (b % 2 == 0){
                b /= 2;
                count++;
            } else {
                b = -1;
            }
        }

        br.close();
    }
}
