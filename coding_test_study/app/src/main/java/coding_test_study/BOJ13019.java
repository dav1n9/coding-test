package coding_test_study;

import java.io.*;

public class BOJ13019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] countA = new int[26];
        int[] countB = new int[26];

        String a = br.readLine();
        String b = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'A']++;
            countB[b.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                System.out.println(-1);
                return;
            }
        }

        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        int result = 0;

        while (idxA >= 0) {  // A를 다 확인할 때까지
            if (a.charAt(idxA) == b.charAt(idxB)) {
                idxA--;
                idxB--;
            } else {
                idxA--;
                result++;
            }
        }
        System.out.println(result);


        br.close();
    }
}
