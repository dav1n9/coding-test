package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    int x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                    break;
                case "push_back":
                    int y = Integer.parseInt(st.nextToken());
                    deque.addLast(y);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
            }
        }
        br.close();
    }
}
