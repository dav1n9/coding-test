package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) return (o1 > o2)? 1: -1;
                else return (Math.abs(o1) > Math.abs(o2))? 1: -1;
            }
        });

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.add(input);
            }
        }

        br.close();
    }
}
