import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1182 {

    static int[] arr;
    static boolean[] isused;
    static int n, m;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        isused = new boolean[n];
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        fun(0, 0);
        
        if ( m == 0 ) cnt--;
        System.out.println(cnt);

        br.close();
    }

    static void fun(int k, int sum) {
        if ( k == n ) {
            if( sum == m )
                cnt++;
            return;
        }
        fun(k+1, sum);
        fun(k+1, sum + arr[k]);
        
    }
}
