package chap1_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PR87377 {
    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        String[] s = solution(input);

        for (String value : s) {
            System.out.print(value + " ");
        }

    }

    public static String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; ++i) {
            for (int j = i + 1; j < line.length; ++j) {
                Point intersection = intersection(line[i][0], line[i][1],line[i][2],  line[j][0],line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point min = getMinimumPoint(points);
        Point max = getMaximumPoint(points);
        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int newX = (int) (p.x - min.x);
            int newY = (int) (max.y - p.y);
            arr[newY][newX] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (double) (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (double) (a1 * b2 - b1 * a2);
        if(x % 1 != 0|| y % 1 != 0) return null;
        return new Point((long) x, (long) y) ;
    }

    private static Point getMinimumPoint(List<Point> points) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point p : points) {
            if (minX > p.x)  minX = p.x;
            if (minY > p.y)  minY = p.y;
        }
        return new Point(minX, minY);
    }

    private static Point getMaximumPoint(List<Point> points) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        for (Point p : points) {
            if (maxX < p.x) maxX = p.x;
            if (maxY < p.y) maxY = p.y;
        }
        return new Point(maxX, maxY);
    }

    private static class Point {
        public final long x;
        public final long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
