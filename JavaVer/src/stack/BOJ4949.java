package stack;

import java.util.*;


public class BOJ4949 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        while(true) {
            boolean fail = false;
            String s = input.nextLine();
            Stack<Character> st = new Stack<>();

            if(s.equals(".")) {
                break;
            }

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[') {
                    st.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if(!st.empty() && st.peek() == '(') {
                        st.pop();
                    } else {    
                        fail = true;
                        break;
                    }
                } else if (s.charAt(i) == ']') {
                    if(!st.empty() && st.peek() == '[') {
                        st.pop();
                    } else {
                        fail = true;
                        break;
                    }
                }
            }

            if(fail || !st.empty()) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }

        }

        input.close();
    }
}
