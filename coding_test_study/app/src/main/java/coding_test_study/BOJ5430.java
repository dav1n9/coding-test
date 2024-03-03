package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            
            String arr = (br.readLine().replace("[", "").replace("]", ""));
            StringTokenizer st = new StringTokenizer(arr, ",");
            
            boolean direction = true;   // true는 왼쪽. false는 오른쪽.
            
            Deque<String> deque = new ArrayDeque<>();
            while(st.hasMoreTokens()) {
                deque.add(st.nextToken()+"");
            }

            boolean isError = false;
            for(int n = 0; n < command.length(); n++) {
                if(command.charAt(n) == 'R') {
                    direction = !direction;
                } else if (command.charAt(n) == 'D'){
                    if(!deque.isEmpty()) {
                        if(direction) deque.pollFirst();
                        else deque.pollLast();
                    } else {
                        isError = true;
                        break;
                    }
                }
            }

            // 출력
            if(!isError) {
                if(deque.isEmpty()) bw.write("[]\n");
                else {
                    bw.write("[");
                    while (deque.size() > 1) {
                        if(direction) bw.write(deque.pollFirst()+",");
                        else bw.write(deque.pollLast()+",");
                    }
                    bw.write(deque.poll()+"]\n");
                }
            } else {
                bw.write("error\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
