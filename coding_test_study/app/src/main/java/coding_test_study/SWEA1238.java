package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA1238 {

    static int n, start;
    static List<List<Integer>> tree;
    static int[] isVis;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            isVis = new int[101];
            tree = new LinkedList<>();
            for (int i = 0; i <= 100; i++) { // 부여될 수 있는 번호가 1이상 100 이하임... 
                tree.add(new LinkedList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < (n/2); i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                tree.get(x).add(y);
            }

            ans = 0;

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            isVis[start] = 1;

            while(!q.isEmpty()) {
                int cur = q.poll();
                System.out.print(cur + " => ");

                for (int i = 0; i < tree.get(cur).size(); i++) {
                    if (isVis[tree.get(cur).get(i)] > 0) continue;

                    isVis[tree.get(cur).get(i)] = isVis[cur] + 1;
                    q.add(tree.get(cur).get(i));
                }
            }

            int max = 0;
            for (int i = 1; i <= 100; i++) {
                if (isVis[i] >= max) {
                    max = isVis[i];
                    ans = i;
                }
            }

            System.out.println("#" + t + " " + ans);
        }

        br.close();
    }
}
