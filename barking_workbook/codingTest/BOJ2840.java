package codingTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2840 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 해당 위치에 있는 데이터 확인 자주하므로 배열 사용
        String[] board = new String[n];
        Arrays.fill(board, "?");
        int index = n-1;
        boolean done = false;
        List<String> charList = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            // index 계산
            index = (index - move + n) % n;

            // 배열에 저장
            if(board[index].equals("?")) {
                board[index] = str;
                charList.add(str);
            } else if(board[index].equals(str)){

            } else if(charList.contains(str)) { // 해당하는 행운의 바퀴가 없다고 판단
                done = true;
                bw.write("!");
                break;
            } else {    // 해당하는 행운의 바퀴가 없다고 판단
                done = true;
                bw.write("!");
                break;
            }
        }

        // 출력하기 (index 부터)
        if(!done) {
            for(int i = 0; i < n; i++) {
                bw.write(board[(index + i) % n]);
            }
        }
        
        br.close();
        bw.flush();
        bw.close();

    }
}
