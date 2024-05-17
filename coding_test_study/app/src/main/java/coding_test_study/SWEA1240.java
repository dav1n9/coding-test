package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA1240 {
    static Map<String, Integer> map = Map.of(
                "0001101", 0,
                "0011001", 1,
                "0010011", 2,
                "0111101", 3,
                "0100011", 4,
                "0110001", 5,
                "0101111", 6,
                "0111011", 7,
                "0110111", 8,
                "0001011", 9

            );

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            // 입력받기
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];

            int x = 0, y = 0; // 가장 마지막 1의 위치 저장
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(line.charAt(j) + "");
                    if (arr[i][j] == 1) {
                        x = i;
                        y = j;
                    }
                }
            }

            // 암호코드 찾기
            StringBuilder sb = new StringBuilder();
            List<Integer> result = new LinkedList<>();
            for (int i = 55; i >= 0; i--) {
                if (sb.length() == 7) {
                    result.add(map.get(sb.toString()));
                    sb = new StringBuilder();
                }
                sb.append(arr[x][y - i]);
            }
            result.add(map.get(sb.toString()));

            // 올바른지 잘못된는지 판단. 잘못된 암호이면 0출력, 올바른 암호이면 합 출력
            int odd = 0;  // 문제 기준 홀수
            int even = 0;
            for (int i = 0; i < result.size(); i++) {
                if (i % 2 == 0) odd += result.get(i);
                else even += result.get(i);
            }
            
            if (((odd * 3) + even) % 10 == 0) System.out.println("#" + t + " " + (odd + even));
            else System.out.println("#" + t + " " + 0);
        }

        br.close();
    }
}