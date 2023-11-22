package chap1_array;

public class PR81302 {
    static final int[] dx = new int[]{0, 0, -1, 1};
    static final int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) {
        String[][] input = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXOOO", "OOOOO", "PXOOO", "OOOOO", "OOOPO"}};
        int[] result = solution(input);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int index = 0;
        for(String[] p : places) {
            char[][] room = new char[places.length][];
            for(int i = 0; i < room.length; i++) {
                room[i] = p[i].toCharArray();
            }
            int result = check(room);
            answer[index++] = result;
        }
        return answer;
    }

    private static int check(char[][] place) {
        for (int j = 0; j < place.length; ++j) {
            for (int i = 0; i < place[j].length; ++i) {
                if (place[j][i] == 'P') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || place[ny][nx] == 'X') continue;
                        if(place[ny][nx] == 'P') return 0;
                        else if(place[ny][nx] == 'O') {
                            for (int a = 0; a < 4; ++a) {
                                int x = nx + dx[a];
                                int y = ny + dy[a];
                                if(y == j && x == i) continue;
                                if (y < 0 || y >= 5 || x < 0 || x >= 5) continue;
                                if (place[y][x] == 'P') return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}

