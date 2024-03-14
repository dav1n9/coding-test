package coding_test_study;

import java.io.*;

public class BOJ5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 처음 입력받은 노드 값은 루트 값.
        Node5639 root = new Node5639(Integer.parseInt(br.readLine()));

        // 빈값을 입력받을 때까지 반복
        while(true) {
            String str = br.readLine();

            if(str == null || str.equals("")) break;

            int newNode = Integer.parseInt(str);
            root = insertNode(root, newNode);
        }        
        postOrder(root);

        br.close();
    }

    /**
     * 값 비교를 통해 작다면 left노드에 크다면 right노드에 삽입한다.
     * 재귀로 구현.
     * 
     * @param node 첫 시작은 루트 값, 재귀적으로 비교할 값이 들어감.
     * @param value 삽입할 노드 값
     * @return 
     */
    public static Node5639 insertNode(Node5639 node, int value) {
        if(node == null) return new Node5639(value);

        if(value < node.data) node.left = insertNode(node.left, value);   // node.left 값이 null 이면 value값을 가지는 노드가 저장될 것.
        else if (value > node.data) node.right = insertNode(node.right, value);

        return node;
    }

    /**
     * 후위 순회하여 출력하는 메소드
     * 
     * @param node 첫 시작은 루트 걊.
     */
    public static void postOrder(Node5639 node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
        
    }
}

class Node5639 {
    int data;
    Node5639 left;
    Node5639 right;

    public Node5639(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}