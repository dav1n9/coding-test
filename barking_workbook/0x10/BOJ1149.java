import java.io.*;
import java.util.*;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (i == 0)
                    arr[i][j] = val;
                else {
                    if (j == 0) arr[i][j] = Math.min(arr[i-1][1], arr[i-1][2]) + val;
                    else if (j == 1) arr[i][j] = Math.min(arr[i-1][0], arr[i-1][2]) + val;
                    else arr[i][j] = Math.min(arr[i-1][0], arr[i-1][1]) + val;
                }
            }
        }

        int min = Math.min(Math.min(arr[n-1][0], arr[n-1][1]), arr[n-1][2]);
        System.out.println(min);

        br.close();
    }
}
