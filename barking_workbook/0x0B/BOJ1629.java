
import java.util.*;

public class BOJ1629 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        long result = fun(a, b, c);
        System.out.println(result);

        input.close();
    }

    public static long fun(int a, int b, int c) {
        if(b == 1) return a % c;

        long val = fun(a, b/2, c);
        val = val * val % c;

        if(b % 2 == 0) return val;
        return val * a % c;
    }
}