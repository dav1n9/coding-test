package coding_test_study;

import java.io.*;

public class BOJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(nextPrimeAndPalindrome(n));


        br.close();
    }

    public static int nextPrimeAndPalindrome(int n) {
        while (true) {
            if(isPalindrome(n) && isPrime(n)) return n;
            n++;
        }
    }

    public static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    // 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는가
    public static boolean isPalindrome(int n) {
        StringBuilder sb = new StringBuilder(n+"");
        if(!sb.toString().equals(sb.reverse().toString())) return false;
        return true;
    }
}
