import java.util.Scanner;

public class BOJ9663 {
    static int n;
    static int cnt = 0; // 성공 갯수
    static boolean[] isused1;
    static boolean[] isused2;
    static boolean[] isused3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();

        isused1 = new boolean[n];
        isused2 = new boolean[2*n-1];
        isused3 = new boolean[2*n-1];

        fun(0);

        System.out.println(cnt);

        input.close();
    }
    static void fun(int k) {
        if(n == k) {
            cnt++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isused1[i] || isused2[i+k] || isused3[k-i+n-1]) 
                continue;
            isused1[i] = true;
            isused2[i+k] = true;
            isused3[k-i+n-1] = true;
            fun(k+1);
            isused1[i] = false;
            isused2[i+k] = false;
            isused3[k-i+n-1] = false;
            
        }
    }
}
