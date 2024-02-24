package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int temp = 1;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            int lastNum = stack.isEmpty() ? 0 : stack.peek();

            if(lastNum < num) { // push가 필요한 상황
                while(lastNum != num) {
                    stack.push(temp++);
                    result.append("+\n");
                    lastNum = stack.peek();
                }
                stack.pop();
                result.append("-\n");
            } else if (lastNum == num) { 
                stack.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(result.toString());

        br.close();
    }
}
