package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ1991 {

    static List<List<String>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 0번째가 A 노드
        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            int index = node.charAt(0) -'A';
            tree.get(index).add(leftChild);
            tree.get(index).add(rightChild);
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
        System.out.println();

        br.close();
    }

    // 전위 순회
    public static void preOrder(String node) {
        if(!node.equals(".")) {
            System.out.print(node);
            preOrder(tree.get(node.charAt(0)-'A').get(0));
            preOrder(tree.get(node.charAt(0)-'A').get(1));
        }
    }

    // 중위 순회
    public static void inOrder(String node) {
        if(!node.equals(".")) {
            inOrder(tree.get(node.charAt(0)-'A').get(0));
            System.out.print(node);
            inOrder(tree.get(node.charAt(0)-'A').get(1));
        }
    }

    // 후위 순회
    public static void postOrder(String node) {
        if(!node.equals(".")) {
            postOrder(tree.get(node.charAt(0)-'A').get(0));
            postOrder(tree.get(node.charAt(0)-'A').get(1));
            System.out.print(node);
        }
    }
}
