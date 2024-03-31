package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ1990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        //if (b >= 9989899) b = 9989899;  // 천만 이상의 소수&팰린드롬 없다.

        for(int i = a; i <= b; i++) {
            if(i > 9989899) break;
            if (isPalindrome(i) && isPrime(i)) bw.append(i+"\n");
        }
        bw.append("-1");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isPalindrome(int n) {
        StringBuilder sb = new StringBuilder(n + "");
        if (!sb.toString().equals(sb.reverse().toString())) return false;
        return true;
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
