package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA1228 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            List<Integer> list = new LinkedList<>();
            for (int i = 0 ; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            
            for (int i = 0; i < k; i++) {
                st.nextToken(); // l
                int idx = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                    
                for (int j = 0; j < count; j++) {
                    list.add(idx++, Integer.parseInt(st.nextToken()));
                }
                    
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

        br.close();
    }
}
