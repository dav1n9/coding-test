package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ2210 {

    static int result = 0;
    static int[][] arr = new int[5][5];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static LinkedList<String> list;    // 중복 없이 여섯자리수 담을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new LinkedList<>();
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(0, i, j, "");
            }
        }

        System.out.println(result);
        br.close();
    }

    public static void dfs(int idx, int x, int y, String val) {
        if (val.length() == 6) {
            if (!list.contains(val)) {
                list.add(val);
                // System.out.println(val);
                result++;
            }
            
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(idx+1, nx, ny, val+arr[nx][ny]);
            }
        }
        
    }
}
