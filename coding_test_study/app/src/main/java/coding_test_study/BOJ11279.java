package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x > 0) { // x가 자연수이면 추가.
                pq.add(x);
            } else {    // 0이면 배열에서 가장 큰 갑 출력
                if(pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            }
        }

        br.close();
    }
}
