package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();

        int allCount = 0;
        while(true) {
            String st = br.readLine();

            if(st == null || st.length() <= 0) break;

            if (!map.containsKey(st)) {
                map.put(st, 1);
            } else {
                map.replace(st, map.get(st)+1);
            }
            allCount++;
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);    // 키 값으로 오름차순 정렬

        // 결과 출력하기
        for(String key : keys) {
            int count = map.get(key);
            bw.append(key + " " + String.format("%.4f", ((float)count / allCount) * 100) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
