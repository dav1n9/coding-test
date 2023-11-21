import java.io.*;

public class BOJ15652 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n ,m;
    static int[] arr = new int[10];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr= br.readLine().split(" ");
        n = Integer.parseInt(sArr[0]);
        m = Integer.parseInt(sArr[1]);

        fun(1, 0);

        br.close();
        bw.flush();
        bw.close();
    }

    static void fun(int start, int k) throws Exception{
        if(k == m) {
            for(int i = 0; i < m; i++)
                bw.write(arr[i] + " ");
            bw.newLine();
            return;
        }
        for(int i = start; i <= n; i++) {
            arr[k] = i;
            fun(i, k+1);
        }
    }
}
