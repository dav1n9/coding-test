import java.util.Arrays;
import java.util.Scanner;

public class BOJ6603 {

    static int[] strArr;
    static boolean[] isused = new boolean[13];
    static int[] result = new int[6];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        String[] temp = s.split(" ");
        strArr = new int[temp.length-1];
        for(int i = 1; i < temp.length; i++) {
            strArr[i-1] = Integer.parseInt(temp[i]);
        }

        while(strArr.length> 1) {
            // 각 테스트 케이스 수를 고르는 방법 출력하기
            Arrays.sort(strArr);

            fun(0, 0);
            System.out.println();


            // 테스트 케이스 입력
            s = input.nextLine();
            temp = s.split(" ");
            strArr = new int[temp.length-1];
            for(int i = 1; i < temp.length; i++) {
                strArr[i-1] = Integer.parseInt(temp[i]);
            }
        }
        input.close();
    }

    static void fun(int k, int start) {
        if(k == 6) {
            for(int i = 0; i < 6; i++)
                System.out.print(result[i] + " ");
            System.out.println();
            
            
            return;
        }
        for(int i = start; i < strArr.length; i++) {
            if(!isused[i] && k <= 6) {
                result[k] = strArr[i];
                isused[i] = true;
                fun(k+1, i);
                isused[i] = false;
            }
        }
    }
}
