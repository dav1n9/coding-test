package coding_test_study;

import java.util.*;

public class SWEA1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = sc.nextInt();
            Deque<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                q.addLast(sc.nextInt());
            }

            int count = 1;
            while (true) {
                int firstNum = q.pollFirst();
                firstNum -= count;

                if (firstNum <= 0) {
                    q.addLast(0);
                    break;
                }

                q.addLast(firstNum);
                
                count++;
                if (count > 5) count = 1;  // 한 사이클은 5까지
            }

            System.out.print("#" + num + " ");
            while (!q.isEmpty()) {
                System.out.print(q.pollFirst() + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
