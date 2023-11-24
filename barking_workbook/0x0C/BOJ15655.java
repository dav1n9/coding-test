import java.util.*;

public class BOJ15655 {
    static int n , m;
    static int[] arr;
    static boolean[] isused = new boolean[8];
    static int[] result = new int[8];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);

        fun(0, 0);


        input.close();
    }
    static void fun(int start, int idx) {
        if (start == m) {
            for(int i = 0; i < m; i++)
                System.out.print(result[i] + " ");
            System.out.println();
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            if(!isused[i]) {
                result[start] = arr[i];
                isused[i] = true;
                fun(start+1, i+1);
                isused[i] = false;
           }
        }
    }
}
