import java.util.Scanner;

// 길이가 m인 수열을 모두 구하는 프로그램
public class BOJ15649 {

    static int n, m;
    static int arr[] = new int[10];
    static boolean isused[] = new boolean[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt(); // 1 ~ n까지의 자연수 중에서
        m = input.nextInt(); // 중복없이 m개를 고른 수열

        fun(0);

        input.close();
    }

    public static void fun(int k) {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!isused[i]) {
                arr[k] = i;
                isused[i] = true;
                fun(k+1);
                isused[i] = false;
            }
        }
    }
}
