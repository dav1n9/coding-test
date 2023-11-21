import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int n, m;
    static int[] arr = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 구분을 위해 StringTokenizer 객체를 함께 사용
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 공백을 구분으로 입력
        m = Integer.parseInt(st.nextToken());

        fun(0);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void fun(int k) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++)
                bw.write(arr[i] + " "); // 출력
            bw.newLine(); // 개행
            return;
        };

        for (int i = 1; i <= n; i++) {
            arr[k] = i;
            fun(k + 1);

        }
    }
}
