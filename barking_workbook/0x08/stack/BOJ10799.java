package stack;

import java.util.*;

public class BOJ10799 {
    public static void main (String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        String s = input.next();
        Stack<Character> st = new Stack<>();

        boolean wasPoped = false;
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
                wasPoped = false;
            } else {    // ')' 이면
                if(!st.empty() && st.peek() == '(') {
                    st.pop();
                    
                    // 1. 레이저인 경우
                    if(!wasPoped) result += st.size();
                    // 2. 짝 찾은 경우
                    else result++;

                    wasPoped = true;
                }
            }
        }

        System.out.println(result);

        input.close();

    }
}