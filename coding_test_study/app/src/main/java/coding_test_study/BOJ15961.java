package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ15961 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());  // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken());  // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());  // 쿠폰 번호

        int[] arr = new int[n];     // 초밥 벨트에 놓인 n개의 초밥 종류
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] checked = new int[d+1];   // d개의 초밥 중 먹은 초밥 종류와 개수를 체크하기 위함.
        checked[c] = 1;

        int cur_eat = 1;   // 쿠폰을 맨 처음 사용한다고 가정.
        int max_eat = 0;

        // 0부터 k 개수만큼 먹었을 때의 초기화
        for (int i = 0; i < k; i++) {
            if (checked[arr[i]] == 0) cur_eat++;
            checked[arr[i]]++;
        }
        max_eat = cur_eat;

        // 슬라이딩 윈도우
        for (int start = 0; start < n; start++) {
            int end = (start + k) % n;
        
            checked[arr[start]]--;
            
            if (checked[arr[start]] == 0) cur_eat--;
            if (checked[arr[end]] == 0) cur_eat++;

            checked[arr[end]]++;

            max_eat = Math.max(max_eat, cur_eat);
        }

        System.out.println(max_eat);

        br.close();
    }
}
