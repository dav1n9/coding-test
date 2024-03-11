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
        
        // removeNode 의 모든 자손에서 리프노드를 찾을 수 없도록 수정한다.
        if (removeNode == root) System.out.println(0);  // removeNode가 root 이면 0 출력.
        else {
            update(removeNode);

            int result = 0;
            for(int i = 0; i < tree.size(); i++) {
                // removeNode 의 부모 노드에서 removeNode를 삭제한다.
                if(tree.get(i).contains(removeNode)) tree.get(i).remove(tree.get(i).indexOf(removeNode));
                // 자손이 없는 노드를 찾는다.
                if(tree.get(i).isEmpty()) result++;
            }
            System.out.println(result);
        }

        br.close();
    }

    public static void update(int node) {
        if(tree.get(node).size() >= 2) update(tree.get(node).get(1));
        if(tree.get(node).size() >= 1) update(tree.get(node).get(0));
        if(tree.get(node).isEmpty()) tree.get(node).add(-2);    
    }
}
