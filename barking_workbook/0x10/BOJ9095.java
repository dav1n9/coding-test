import java.io.*;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int k = 4; k < 11; k++) {
            d[k] = d[k-1] + d[k-2] + d[k-3];
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }

        br.close();
    }
}
