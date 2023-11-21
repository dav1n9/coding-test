import java.util.Scanner;

public class BOJ1780 {
    static int[][] a;
    static int[] result;

    /*
     * x ~ (x+size) 
     * y ~ (y+size)
     * 만큼의 사각형이 같은 숫자로 채워져있는지 확인함.
     */
    static boolean check(int size, int x, int y) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (a[x][y] != a[i][j])
                    return false;
            }
        }
        return true;
    }

    static void fun(int size, int x, int y) {
        if (check(size, x, y)) {    // 같은 숫자로 채워져 있으면, 해당 종이 갯수 + 1
            result[a[x][y] + 1] += 1;
            return;
        }

        int n = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fun(n, x + i * n, y + j * n);   // 9등분
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        a = new int[n][n];
        result = new int[3]; // -1, 0, 1 로 채워진 종이 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = input.nextInt();
            }
        }
        fun(n, 0, 0);
        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }

        input.close();
    }
}
