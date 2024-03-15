package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ9489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            List<Node9489> tree = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(n == 0 && k == 0) break;

            int[] testcase = new int[n];    // 각 테스트 케이스 배열에 저장
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                testcase[i] = Integer.parseInt(st.nextToken());
            }

            int searchDataIdx = 0;
            int nodeIdx = 0;
            for(int i = 1; i < n; i++) {           
                // tree.get(idx)
                if (testcase[i] - testcase[i-1] > 1) {  // 이전 노드 값과 2이상 차이나면
                    Node9489 node = new Node9489(testcase[searchDataIdx++]); //q.poll() 값을 data로 가지는 새로운 노드 생성
                    node.child.add(testcase[i]);    // testcase[i] 값을 노드의 자식으로 추가
                    tree.add(node);    // 해당 노드를 트리에 추가

                    nodeIdx++;  // 다음 생성할 노드의 인덱스

                } else {    // 이전 노드 값과 1차이나면
                    // 새로운 노드를 생성하지 않으므로, (다음 생성할 노드 인덱스 -1) 번 노드에 자식을 추가한다. 
                    tree.get(nodeIdx-1).child.add(testcase[i]);
                }
            }

            // 레벨 설정
            int level = 0;
            int findLevel = 0;
            int count = 0;
            for(int i = 1; i < tree.size(); i++){
                if(count == 0) {
                    count = tree.get(level).child.size();
                    level++;
                }
                tree.get(i).level = level;  // 트리의 레벨 저장 (리프노드는 제외)
                count--;

                // k의 부모 레벨 저장 (k의 부모 레벨을 살펴보며 자식의 개수를 세기 위함)
                if(tree.get(i).child.contains(k)) findLevel = tree.get(i).level;
            }
            // 트리 읽기 -> 같은 레벨의 Node 뽑고, 같은 부모인 애들 빼고 개수 세기
            int result = 0;
            for(int i = 0; i < tree.size(); i++) {
                if(tree.get(i).level == findLevel && !tree.get(i).child.contains(k)) {
                    result += tree.get(i).child.size();
                }
            }
            System.out.println(result);
        }

        br.close();
    }
}

class Node9489 {
    int data;
    int level;
    List<Integer> child;

    public Node9489(int data) {
        this.data = data;
        this.level = 0;
        child = new ArrayList<>();
    }
}