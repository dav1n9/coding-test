import java.io.*;
import java.util.*;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[2000001];
        int n = Integer.parseInt(br.readLine());
        

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) System.out.println(i - 1000000);
        }

        br.close();
    }
}
