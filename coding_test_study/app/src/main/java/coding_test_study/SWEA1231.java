package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA1231 {
    static int n;
    static List<List<Integer>> tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String str = st.nextToken();

                tree.get(idx).add(str.charAt(0) - 'A');

                while (st.hasMoreTokens()) {
                    tree.get(idx).add(Integer.parseInt(st.nextToken()));
                }
            }

            System.out.print("#" + t + " ");
            inOrder(1, 0);
            System.out.println();
        }

        br.close();
    }

    public static void inOrder(int idx, int count) {
        if (tree.get(idx).size() >= 2)
            inOrder(tree.get(idx).get(1), count+1);

        System.out.print((char)(tree.get(idx).get(0) + 'A'));

        if (tree.get(idx).size() == 3)
            inOrder(tree.get(idx).get(2), count+1);
        
    }
}
