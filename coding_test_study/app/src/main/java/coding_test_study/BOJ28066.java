package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ28066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while(deque.size() > 1) {
            if(deque.size() < k) {
                System.out.println(deque.pollFirst());
                return;
            } else {
                deque.addLast(deque.pollFirst());
            
                for(int i = 0; i < k-1; i++) {
                    deque.pollFirst();
                }
            }
        }

        System.out.println(deque.poll());
        br.close();
    }
}
