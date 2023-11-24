import java.io.*;
import java.util.*;

class BOJ15654 {
    static int n ,m;
    static int[] arr;
    static int[] result = new int[8];
    static boolean[] isused = new boolean[8];
    static List<String> list = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        fun(0);
        for(String s : list) {
            System.out.println(s);
        }

        br.close();
    }

    static void fun(int node) {
        if(node == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(result[i]+ " ");
            }
            list.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < n; i++) {
            if(!isused[i]) {
                result[node] = arr[i];
                isused[i] = true;
                fun(node+1);
                isused[i] = false;
            }
        }
    }
}