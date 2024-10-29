import java.io.*;
import java.util.*;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n+1]; // N == 1 이면 D[0], D[1] 까지 인덱스가 생성되기 때문에 10번째 줄 D[2] = 2; 에서 에러
        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);

        br.close();
    }
    
}
