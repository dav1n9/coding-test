package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ21275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        Long[] arrA = new Long[37];
        Long[] arrB = new Long[37];
        Arrays.fill(arrA, 0L);
        Arrays.fill(arrB, 0L);  // null 방지를 위해 0L으로 채워줌.
        
        // a의 최소진법 구하기
        char maxA = '0';
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > maxA) maxA = a.charAt(i);
        }
        int maxAtoNum = (Character.isAlphabetic(maxA))?maxA - 'a' + 10: maxA - '0';

        // b의 최소진법 구하기
        char maxB = '0';
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) > maxB) maxB = b.charAt(i);
        }
        int maxBtoNum = (Character.isAlphabetic(maxB))?maxB - 'a' + 10: maxB - '0';

        // a의 최소진법부터 N 진법인 a를 10진법으로 변환하여 arrA에 저장
        if(!a.equals("0")) {
            for(int i = maxAtoNum + 1; i <= 36; i++) {
                try {
                    Long.parseLong(a, i);
                } catch (NumberFormatException e) {
                    arrA[i] = -1L;
                    continue;
                }
                arrA[i] = Long.parseLong(a, i);
            }
        }
        
        // b의 최소진법부터 N 진법인 b를 10진법으로 변환하여 arrB에 저장
        if(!a.equals("0")) {
            for(int i = maxBtoNum + 1; i <= 36; i++) {
                try {
                    Long.parseLong(b, i);
                } catch (NumberFormatException e) {
                    arrB[i] = -1L;
                    continue;
                }
                arrB[i] = Long.parseLong(b,i);
            }
        }

        // 같은 값이 있는지 확인
        boolean isFin = false;
        int count = 0;
        int resultA = 0;
        int reusltB = 0;
        for(int i = maxAtoNum+1; i <= 36; i++) {
            for(int j = maxBtoNum+1; j <= 36; j++) {
                if ((arrA[i] == arrB[j] || arrA[i].equals(arrB[j])) && arrA[resultA] != -1 && arrB[reusltB] != -1) {
                    count++;
                    if(count > 1) {
                        System.out.println("Multiple");
                        isFin = true;
                        break;
                    }
                    resultA = i;
                    reusltB = j;
                    
                }
            }
            if(isFin) break;
        }
        if(!isFin) {
            if (count == 0 || resultA == reusltB || arrA[resultA] == -1 || arrB[reusltB] == -1) System.out.println("Impossible");
            else System.out.println(arrA[resultA] + " " + resultA + " " + reusltB);
        }
        


        br.close();
        bw.flush();
        bw.close();
    }
}