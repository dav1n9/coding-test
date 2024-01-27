import java.util.Scanner;

class BOJ18808 {
    public static int[][] board;
    public static int[][] sticker;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt(); // 세로
        m = input.nextInt(); // 가로
        int k = input.nextInt(); // 스티커

        board = new int[n][m];

        // 반복하면서 board에 들어가는지 확인하기
        while (k-- > 0) {
            int stickerHeight = input.nextInt();
            int stickerWidth = input.nextInt();
            sticker = new int[stickerHeight][stickerWidth];

            // 스티커 배열에 저장
            for (int h = 0; h < stickerHeight; h++) {
                for (int w = 0; w < stickerWidth; w++) {
                    sticker[h][w] = input.nextInt();
                }
            }
            for (int rul = 0; rul < 4; rul++) {
                boolean isDone = false;
                // 이동하면서 확인
                for (int i = 0; i <= (n - sticker.length); i++) {
                    if (isDone)
                        break;
                    for (int j = 0; j <= (m - sticker[0].length); j++) {
                        if (pastable(i, j)) {
                            isDone = true;
                            break;
                        }
                    }
                }

                if (isDone)
                    break;
                // 모든 경우 불가능하면 90도 회전
                rotate();
            }
        }

        // 스티커가 붙은 칸의 수 세기
        int count = 0;
        for (int b = 0; b < board.length; b++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[b][c] == 1)
                    count++;
            }
        }

        System.out.println(count);

        input.close();
    }

    static void boardPrint() {
        System.out.println("----board 프린트");
        for (int b = 0; b < board.length; b++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[b][c] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    static void rotate() {
        int y = sticker[0].length;
        int x = sticker.length;
        int[][] stickerTemp = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                stickerTemp[i][j] = sticker[x - 1 - j][i];
            }
        }
        sticker = stickerTemp;
    }

    // x, y는 board 에서의 시작점
    // false가 반환되면 실패, true가 반환되면 성공
    static boolean pastable(int x, int y) {
        int stickerX = sticker.length;
        int stickerY =  sticker[0].length;
        for (int i = 0; i < stickerX; i++) {
            for (int j = 0; j < stickerY; j++) {
                if(x+i >= board.length || y+j >= board[0].length) return false;
                if (board[x + i][y + j] == 1 && sticker[i][j] == 1)
                    return false;
            }
        }

        // 가능하다면
        for (int i = 0; i < stickerX; i++) {
            for (int j = 0; j < stickerY; j++) {
                if (sticker[i][j] == 1) {
                    board[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }
}