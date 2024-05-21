package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String file = st.nextToken(); // -> 사실 필요없는 값.
            String extension = st.nextToken(); // 확장자명
            int val = 0;
            if (map.containsKey(extension)) {
                val = map.get(extension);
            }
            map.put(extension, val+1);
        }

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }

        br.close();
    }
}
