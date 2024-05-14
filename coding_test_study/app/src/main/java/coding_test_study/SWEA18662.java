package coding_test_study;

import java.io.*;
import java.util.*;

public class SWEA18662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            int[] nums = new int[3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 이미 등차수열인 경우 pass.
            if (nums[1] - nums[0] == nums[2] - nums[1]) {
                System.out.println("#" + t + " " + 0.0);
                continue;
            }

            // 가장 작은 x값 찾기
            double min = Integer.MAX_VALUE;

            // 1. a 값 바꾸기
            double temp = nums[1] - (nums[2] - nums[1]);
            min = Math.min(min, Math.abs(temp -  nums[0]));
            
            // 2. b 값 바꾸기
            temp = (double)(nums[0] + nums[2]) / 2.0;
            min = Math.min(min, Math.abs(temp - nums[1]));
            
            // 3. c 값 바꾸기
            temp = nums[1] + (nums[1] - nums[0]);
            min = Math.min(min, Math.abs(temp - nums[2]));

            System.out.println("#" + t + " " + min);

        }

        br.close();
    }
}
