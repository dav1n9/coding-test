import java.util.*;

public class BOJ11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr, (p1, p2) -> {
            if (p1.x == p2.x) return p1.y - p2.y;
            else return p1.x - p2.x;
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }

        sc.close();
    }

    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
