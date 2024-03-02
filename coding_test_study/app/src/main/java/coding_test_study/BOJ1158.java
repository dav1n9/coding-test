package coding_test_study;

import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            for(int i = 0; i < k-1; i++) {
                int temp = queue.remove();
                queue.add(temp);
            }
            result.add(queue.remove() + "");
        }
        
        System.out.print("<" + String.join(", ", result) + ">");

        input.close();
    }
}
