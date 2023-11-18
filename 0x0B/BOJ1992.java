import java.util.Scanner;

public class BOJ1992 {
    static int[][] board;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = input.next();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }

        solve(0, 0, n);
        input.close();
    }

    static boolean check(int x, int y, int size) {
        for(int i = x; i <x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void solve(int x, int y, int size) {
        
        if(check(x, y, size)) {
            System.out.print(board[x][y]);
            return ;
        }
        System.out.print("(");
        int n = size/2;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                solve(x+i*n, y+j*n, n);
            }
        }
        System.out.print(")");

    }
}
