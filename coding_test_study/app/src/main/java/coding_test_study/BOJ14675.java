package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ14675 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			tree[i] = new ArrayList<>();
		}

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int k = Integer.parseInt(br.readLine());  // 질의 수

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                if (tree[b].size() > 1) bw.append("yes\n"); // 2개이상 연결이면 yes
                else  bw.append("no\n");
            } else {
                bw.append("yes\n");  // 간선은 항상 yes가 아닌가..?
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
}