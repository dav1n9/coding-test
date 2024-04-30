package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA1218 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            char[] chars = new char[len];
            boolean isPos = true;

            chars = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(' || chars[i] == '<') 
                    stack.push(chars[i]);
                else {
                    char pop = stack.pop();
                    if (pop == '{' && chars[i] == '}') continue;
                    else if (pop == '[' && chars[i] == ']') continue;
                    else if (pop == '(' && chars[i] == ')') continue;
                    else if (pop == '<' && chars[i] == '>') continue;
                    else {
                        isPos = false;
                        break;
                    }
                }
            }

            if (isPos) System.out.println("#" + t + " " + 1);
            else System.out.println("#" + t + " " + 0);
        }

        br.close();
    }
}
