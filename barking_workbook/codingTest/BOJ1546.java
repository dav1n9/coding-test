package codingTest;

import java.util.*;

public class BOJ1546 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        double[] scores = new double[n];
        double maxScore = 0;

        for(int i = 0; i < n; i++) {
            scores[i] = input.nextInt();
            if(maxScore < scores[i]) maxScore = scores[i];
        }

        // 새로운 점수 업데이트
        double sum = 0;
        for(int i = 0; i < n; i++) {
            scores[i] = (scores[i] / maxScore * 100);
            sum += scores[i];
        }

        // 평균
        double average = sum / (double)n;
        System.out.println(average);

        input.close();
    }
}
