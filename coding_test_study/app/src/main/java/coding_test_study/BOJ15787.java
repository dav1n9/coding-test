package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 기차 수
        int[][] trains = new int[n+1][21];
        
        int m = Integer.parseInt(st.nextToken());  // 명령 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = 0, x = 0;
            switch (num) {
                case 1: // k번째 기차에 x좌석에 태우기
                    k = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    trains[k][x] = 1;
                    break;
                case 2:  // k번째 기차에 x좌석 하차
                    k = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    trains[k][x] = 0;
                    break;
                case 3:  // k번째 기차 승객들 모두 한칸식 뒤로 이동 (20번째 좌석사람 하차차)
                    k = Integer.parseInt(st.nextToken());
                    for (int idx = 20; idx >= 2; idx--) {
                        trains[k][idx] = trains[k][idx-1];
                    }
                    trains[k][1] = 0;
                    break;
                case 4:  // k번째 기차 승객들 모두 한칸식 앞으로 이동
                    k = Integer.parseInt(st.nextToken());
                    for (int idx = 2; idx <= 20; idx++) {
                        trains[k][idx-1] = trains[k][idx];
                    }
                    trains[k][20] = 0;
                    break;
            
                default:
                    break;
            }
        }

        Set<String> set = new TreeSet<>();
        for (int i = 1; i < trains.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                sb.append(trains[i][j]);
            }
            set.add(sb.toString());
        }

        System.out.println(set.size());

        br.close();
    }
}
