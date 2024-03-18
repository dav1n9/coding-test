package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ1068 {

    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int root = 0;

        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode == -1) root = i;
            else tree.get(parentNode).add(i);
        }

        int removeNode = Integer.parseInt(br.readLine());
        if (removeNode == root) System.out.println(0);  // removeNode가 root 이면 0 출력.
        else {
            // removeNode 의 부모 노드에서 removeNode를 제외하고 탐색한다.
            int result = 0;

            Queue<Integer> q = new LinkedList<>();
            boolean[] isVisited = new boolean[n];
            q.add(root);

            while(!q.isEmpty()) {
                int cur = q.poll();

                int nodeSize = tree.get(cur).size();
                if(tree.get(cur).contains(removeNode)) nodeSize--;
                if(nodeSize == 0 && cur != removeNode) result++;
                
                isVisited[cur] = true;

                for(int a : tree.get(cur)) {
                    if(!isVisited[a] && a != removeNode) q.add(a); 
                }
            }
            System.out.println(result);
        }

        br.close();
    }
}
