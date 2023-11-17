import java.util.*;

public class BOJ1074 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int r = input.nextInt();
        int c = input.nextInt();

        System.out.println(fun(n, r, c));

        input.close();
    }

    // n => 2 ^ n
    public static int fun(int n, int r, int c) {
        if (n == 0)
            return 0;
        int half = 1 << (n - 1);
        if (r < half && c < half) {
            return fun(n-1, r, c);
        }
        if (r < half && c >= half) {
            return (half) * (half) + fun(n-1, r, c-half);
        }
        if (r >= half && c < half) {
            return (half * half) * 2 + fun(n-1, r-half, c);
        }
        return (half * half) * 3 + fun(n-1, r-half, c-half);

    }
}
