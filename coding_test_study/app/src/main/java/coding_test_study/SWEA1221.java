package coding_test_study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1221 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for (int test_case = 1; test_case <= t; test_case++) {
            String num = input.next();
            int len = Integer.parseInt(input.next());

            int[] arr = new int[len];
            for(int i = 0; i < len; i++) {
                String word = input.next();
                if (word.equals("ZRO")) arr[i] = 0;
                else if (word.equals("ONE")) arr[i] = 1;
                else if (word.equals("TWO")) arr[i] = 2;
                else if (word.equals("THR")) arr[i] = 3;
                else if (word.equals("FOR")) arr[i] = 4;
                else if (word.equals("FIV")) arr[i] = 5;
                else if (word.equals("SIX")) arr[i] = 6;
                else if (word.equals("SVN")) arr[i] = 7;
                else if (word.equals("EGT")) arr[i] = 8;
                else if (word.equals("NIN")) arr[i] = 9;
            }

            Arrays.sort(arr);

            System.out.println(num);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++) {
                if (arr[i] == 0) sb.append("ZRO");
                else if (arr[i] == 1) sb.append("ONE");
                else if (arr[i] == 2) sb.append("TWO");
                else if (arr[i] == 3) sb.append("THR");
                else if (arr[i] == 4) sb.append("FOR");
                else if (arr[i] == 5) sb.append("FIV");
                else if (arr[i] == 6) sb.append("SIX");
                else if (arr[i] == 7) sb.append("SVN");
                else if (arr[i] == 8) sb.append("EGT");
                else if (arr[i] == 9) sb.append("NIN");

                if (i == (len-1)) System.out.println(sb.toString());
                sb.append(" ");
            }

        }

        input.close();
    }
}
