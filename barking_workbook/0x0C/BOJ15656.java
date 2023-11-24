import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656 {
    static int n , m;
    static int[] arr;
    static int[] result = new int[8];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        fun(0);

        input.close();
        bw.flush();
        bw.close();
    }

    static void fun(int k) throws IOException {
        if( k == m ) {
            for(int i = 0; i < m; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            result[k] = arr[i];
            fun(k+1);
        }
    }

}
