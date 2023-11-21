import java.util.*;

// 1~n까지 자연수 중에서 중복없이 m개를 고른 수열
public class BOJ15650 {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();

        fun(1, 0);

        input.close();
    }

    public static void fun(int start, int k) {
        if (m == k) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!isused[i]) {
                arr[k] = i;
                isused[i] = true;
                fun(i+1, k + 1);
                isused[i] = false;
            }
        }
    }
}
