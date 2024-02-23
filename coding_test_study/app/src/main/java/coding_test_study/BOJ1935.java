package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String command = br.readLine();

        Double[] numbers = new Double[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = (double) Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if(c >= 'A' && c <= 'Z') {  // 피연산자이면
                stack.push(numbers[c-'A']);
            } else {    // 연산자이면
                double num1 = stack.pop();
                double num2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                }

            }
        }

        System.out.printf("%.2f", stack.pop());
        

        br.close();
    }
}
