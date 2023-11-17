package bfs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();

        int [] check = new int[200001];
        for(int i = 0; i < check.length; i++)
            check[i] = -1;

        System.out.println(findResult(m ,n ,check));

        input.close();
    }

    public static int findResult(int m, int n, int[] check) {
        Queue<Map<Integer, Integer>> q = new LinkedList<>();
        q.offer(Map.of(m, 0));
        check[m] = 0;

        while(!q.isEmpty()) {
            Map<Integer, Integer> curIndex = q.peek();
            q.poll();
            int index = curIndex.keySet().iterator().next();
            int distance = curIndex.get(index);
            if(index == n) return distance;
            for(int i = 0; i <= 2; i++) {
                int dindex = moveIndex(i, index);

                // 성공
                if(dindex == n) {
                    return distance + 1;
                }
                if(dindex < 0 || dindex > 200000) continue;
                if(check[dindex] >= 0) continue;
                
                check[dindex] = distance;
                q.add(Map.of(dindex, distance+1));
                
            }
        }
        return 0;
    }

    public static int moveIndex(int i, int x) {
        if(i == 0) {
            return x -1;
        } else if(i == 1) {
            return x +1;
        } else {
            return 2* x;
        }
    }
}
