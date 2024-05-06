package coding_test_study;

import java.util.*;

public class SWEA1258 {

    static int[][] arr;
    static int[][] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();
        for (int t = 1; t <= test_case; t++) {
            int size = sc.nextInt();
            arr = new int[size][size];
            checked = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 찾기
            List<Rec> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    // 행과 열 구해서 리스트에 추가
                    if (arr[i][j] > 0 && checked[i][j] == 0) {
                        list.add(findRec(i, j));
                    }

                }
            }

            Collections.sort(list, (r1, r2) -> {
                if (r1.area == r2.area) {
                    return r1.h - r2.h;
                } else return r1.area - r2.area;
            });

            System.out.print("#" + t + " " + list.size() + " ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).h + " " + list.get(i).w + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    private static Rec findRec(int x, int y) {
        int h = 0;
        for (int i = 0; i < arr.length - x; i++) {
            if (arr[x+i][y] > 0) h++;
            else break;
        }
        int w = 0;
        for (int i = 0; i < arr.length - y; i++) {
            if (arr[x][y+i] > 0) w++;
            else break;
        }

        for (int i = x; i < x + h; i++) {
            for (int j = y; j < y + w; j++) {
                checked[i][j] = 1;
            }
        }
        
        return new Rec(h, w);
    }

    private static class Rec {
        int h;
        int w;
        int area;

        public Rec(int h, int w) {
            this.h = h;
            this.w = w;
            this.area = h * w;
        }
    }
}
