package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ9372 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = 0, m = 0;
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());   // 국가의 수
                m = Integer.parseInt(st.nextToken());   // 비행기의 종류
            }
            int[][] graph = new int[n+1][n+1]; // 그래프 표현할 행렬
            boolean[] vis = new boolean[n+1];

            while(m-- > 0) {    // 왕복 비행기 루트 입력
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());   // 국가의 수
                int b = Integer.parseInt(st.nextToken());   // 비행기의 종류
                
                // 왕복 비행기니까 (무방향 그래프) 2가지 경우 표시
                graph[a][b] = 1;
                graph[b][a] = 1;
            }
            // 모든 국가 여행하기 위한 비행기의 최소 개수
            // bfs 탐색
            Queue<Integer> q = new LinkedList<>();
            
            q.add(1);
            vis[1] = true;
            int dis = 0;
            while(!q.isEmpty()) {
                int cur = q.poll();
                dis++;
                for(int i = 1; i <= n; i++) {
                    if(graph[cur][i] != 0 && !vis[i]) { // 비행기가 존재하면서 방문하지 않을 경우
                        vis[i] = true;
                        q.add(i);
                    }
                }
            }
            bw.write(dis-1 +"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}