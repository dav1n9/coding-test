package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        List<List<Integer>> tree = new ArrayList<>();
        int[] parents = new int[n+1];
        boolean[] vis = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            List<Integer> childList = new ArrayList<>();
            tree.add(childList);
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parents[1] = -1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            vis[cur] = true;
            for(int a : tree.get(cur)) {
                if (cur == 1) parents[a] = 1;   //  1의 인접노드 부모는 반드시 1이다.

                // cur의 부모는 무조건 정해져있는 상태 이므로, 반대의 경우는 생각하지 않음.
                //     ex. parents[cur] == 0 인 경우
                else if(parents[a] == 0) {  // 인접노드 a의 부모가 정해지지 않았으면,
                    parents[a] = cur;       // cur을 a의 부모로 설정. cur의 부모는 이미 있으므로, cur은 a의 부모가 되어야함.
                }

                if(!vis[a]) q.add(a);   //  인접노드 a에 방문되지 않았다면 q에 추가.
            }
        }

        for(int i = 2; i < parents.length; i++) {
            bw.write(parents[i] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
