package coding_test_study;

import java.io.*;

public class SWEA2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[size][size];
            for (int i = 0; i < size; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = Integer.parseInt(str.charAt(j) + "");
                }
            }
            
            int startIdx = size / 2;
            int count = 1;
            int ans = 0;
            boolean increased = true;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < count; j++) {
					ans += arr[i][startIdx + j];                
                }
                
                if (startIdx == 0) increased = false;
                
                if (increased) {
                    startIdx--;
                    count += 2;
                } else {
                    startIdx++;
                    count -= 2;
                }
            }
            System.out.println("#" + test_case + " " + ans);	

		}
        br.close();
	}
}
