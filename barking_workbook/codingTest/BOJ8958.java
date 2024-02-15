package codingTest;

import java.util.*;

public class BOJ8958 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for(int i = 0; i < n ; i++) {
            char[] testCase = input.next().toCharArray();
            int score = 0;
            int temp = 0;
            for(int j = 0; j < testCase.length; j++) {
                if(testCase[j] == 'O') {
                    score += (++temp);
                } else {
                    temp = 0;
                }
            }
            System.out.println(score);
        }

        input.close();
    }
}
