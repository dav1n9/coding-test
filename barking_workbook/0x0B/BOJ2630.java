import java.util.Scanner;

public class BOJ2630 {
    static int[][] board;
    static int[] check;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        board = new int[n][n];
        check = new int[2]; //흰색은 0번 인덱스, 파란색은 1번 인덱스
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = input.nextInt();
            }
        }

        solve(0, 0, n);
        for(int i = 0; i < 2; i++)
            System.out.println(check[i]);

        input.close();
    }

    static boolean check(int x, int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(board[i][j] != board[x][y])
                    return false;
            }
        }
        return true;
    }

    static void solve(int x, int y, int size) {
        if(check(x, y, size)) {
            check[board[x][y]] += 1;
            return ;    // !!필수!!
        }
        int n = size/2;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                solve(x + (i * n), y + (j * n), n);
            }
        }
    }
}
