package chap1_array;

public class PR68645_2 {
    private static final int[] dx = new int[]{0, 1, -1};
    private static final int[] dy = new int[]{1, 0, -1};

    public static void main(String[] args) {
        int[] arr = solution(5);

        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    public static int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }


        int[] result = new int[v - 1];
        int index = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }
}
