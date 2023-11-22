package chap1_array;

import java.util.Stack;

public class PR68645 {
    public static void main(String[] args) {
        int[] arr = solution(5);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static int[] solution(int n) {
        int[] answer;
        int[][] arr = new int[n][n];
        boolean[][] check = new boolean[n][n];

        for(int i = 1; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                check[i][j] = true;
            }
        }

        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        int value = 1;
        arr[0][0] = value++;
        check[0][0] = true;
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(0, 0));
        int idx = 0;
        while(!stack.empty()) {
            Point cur = stack.pop();
            int nx = cur.x;
            int ny = cur.y;
            while(true) {
                nx += dx[idx];
                ny += dy[idx];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || check[ny][nx] || arr[ny][nx] != 0) {
                    break;
                }
                stack.add(new Point(nx, ny));
                check[ny][nx] = true;
                arr[ny][nx] = value++;
            }
            idx = (idx+1) % 3;
        }

        answer = new int[value - 1];
        int index = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j <= i; ++j) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }

    private static class Point {
        public int x;
        public int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

