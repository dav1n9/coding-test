package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();

        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        // ListIterator 만들고, cursor 위치를 마지막으로 이동시켜야 함.
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }
        

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
            if(command.equals("L")) {
                if(iter.hasPrevious())
                    iter.previous();
            } else if (command.equals("D")) {
                if(iter.hasNext())
                    iter.next();
            } else if(command.equals("B")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }   
            } else if(command.equals("P")) {
                char ch = st.nextToken().charAt(0);
                iter.add(ch);
            }
        }

        while(iter.hasPrevious()) {
            iter.previous();
        }
        while (iter.hasNext()) {
            bw.write(iter.next());
        }

        br.close();
        bw.flush();
		bw.close(); 
    }
}
