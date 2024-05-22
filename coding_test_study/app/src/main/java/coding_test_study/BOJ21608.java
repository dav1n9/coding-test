package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ21608 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n]; // 결과 저장
        int[][] info = new int[n*n][5];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n*n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                info[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
            map.put(info[i][0], List.of(info[i][1], info[i][2],info[i][3],info[i][4]));

            // 해당 번호 학생 자리 정하기
            int[][][] temp = new int[n][n][2]; // 결과 저장 (x, y, z -> 0 : 좋아하는학생수/ 1: 비어있는 칸 수 ) 
            // 첫학생의 경우 (1,1)으로 지정.
            if (i == 0) {
                board[1][1] = info[i][0];
                temp[1][1][0] = -1;
                continue;
            }

            // 1. 좋아하는 학생이 인접한 칸에 가장 많은 칸 찾기

            // 좋아하는 학생 수와 비어있는 칸 수 저장
            int maxLike = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (board[x][y] > 0) continue;

                    for (int nx = 0; nx < 4; nx++) {
                        if (x + dx[nx] < 0 || x + dx[nx] >= n || y + dy[nx] < 0 || y + dy[nx] >= n) continue;
                        if (temp[x + dx[nx]][y + dy[nx]][0] == -1) continue;


                        for (int friend = 1; friend <= 4; friend++) {
                            if (board[x + dx[nx]][y + dy[nx]] == info[i][friend]) temp[x][y][0]++;
                        }
                        if (board[x + dx[nx]][y + dy[nx]] == 0) temp[x][y][1]++;

                        maxLike = Math.max(maxLike, temp[x][y][0]);
                    }
                }
            }

            // 적절한 위치에 학생 자리 정하기
            List<Point21608> list = new LinkedList<>();
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    //System.out.print(temp[x][y][0] + " ");
                    if (temp[x][y][0] == maxLike && board[x][y] == 0) {
                        list.add(new Point21608(x, y, temp[x][y][1]));
                    }
                }
                //System.out.println();
            }

            Collections.sort(list, (p1, p2) -> {
                if (p1.empty == p2.empty) {
                    if (p1.x == p2.x) return p1.y - p2.y;
                    return p1.x - p2.x;
                } else {
                    return p2.empty - p1.empty;
                }
            });

            //for (Point21608 p : list) System.out.print(p.x + ", " + p.y + ", " + p.empty + " => ");
            //System.out.println("ans :: " + list.get(0).x + ", " + list.get(0).y + " : " + info[i][0]);

            board[list.get(0).x][list.get(0).y] = info[i][0];
            temp[list.get(0).x][list.get(0).y][0] = -1;

        }

        // 학생들의 최종 자리
        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < n; j++) {
        //        System.out.print(board[i][j]+ " ");
        //    }
        //    System.out.println();
        //}

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> l = map.get(board[i][j]);
                if (l == null) continue;

                int count = 0;
                for (int nx = 0; nx < 4; nx++) {
                    if (i + dx[nx] < 0 || i + dx[nx] >= n || j + dy[nx] < 0 || j + dy[nx] >= n) continue;
                
                    if (l.contains(board[i + dx[nx]][j + dy[nx]])) count++;
                }
                if (count == 1) ans += 1;
                else if (count == 2) ans += 10;
                else if (count == 3) ans += 100;
                else if (count == 4) ans += 1000;
            }
        }

        System.out.println(ans);

        br.close();
    }

    private static class Point21608 {
        int x;
        int y;
        int empty;

        private Point21608(int x, int y, int empty) {
            this.x = x;
            this.y = y;
            this.empty = empty;
        }
    }
}
