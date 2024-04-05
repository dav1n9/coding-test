package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, Integer> map;

        int t = Integer.parseInt(br.readLine());    // 테스트케이스 수 입력받기
        while (t-- > 0) {
            map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());    // 연산의 개수 입력받기
            while(k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    if(!map.containsKey(n)) map.put(n, 1);
                    else map.put(n, map.get(n) + 1);
                } else if (command.equals("D")) {
                    if (!map.isEmpty()) {
                        int removeKey = (n > 0) ? map.lastKey() : map.firstKey();
                        
                        if (map.get(removeKey) <= 1) map.remove(removeKey);
                        else map.put(removeKey, map.get(removeKey)-1);

                    }
                }
            }

            // 출력
            if(map.isEmpty()) System.out.println("EMPTY");
            else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
        br.close();
    }
}
