package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ3190 {

    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0};
    // 처음 이동방향 -> 오른쪽 index = 0
    static int cur_idx = 0;
    static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        snake.add(new int[] {0, 0});    // (0, 0) 부터 시작
        int resultTime = 0;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        int k = Integer.parseInt(br.readLine());    // 사과의 개수
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            board[r][c] = -1;   // 사과
        }

        int l = Integer.parseInt(br.readLine());  // 뱀의 방향 변환 횟수
        Queue<Map<Integer, Character>> command = new LinkedList<>();
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int seconds = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            command.add(Map.of(seconds, ch));
        }

        boolean done = false;
        Map<Integer, Character> nextCommad = command.poll();
        int key = nextCommad.keySet().iterator().next();    // 시간
        char value = nextCommad.get(key);    // 이동 방향

        while(!done) {
            // 시간++
            resultTime++;

            // 이동
            // 사과 있으면 늘어나기, 없으면 이동
            int[] snakeHead = snake.getFirst();
            int[] newBody = new int[] {snakeHead[0] + dx[cur_idx], snakeHead[1] + dy[cur_idx]};
            //snake.add();

            if(newBody[0] < 0 || newBody[0] > (n-1) || newBody[1] < 0 || newBody[1] > (n-1)) { // 벽에 부딪히면
                done = true;
                continue;
            } else if(ishitted(newBody)) {  // 뱀 몸에 부딪히면
                done = true;
                continue;
            }

            if(board[newBody[0]][newBody[1]] == -1) {   // 사과이면
                snake.addFirst(newBody);
                board[newBody[0]][newBody[1]] = 0;  // 사과 없애기
            } else {    // 사과가 아니면
                snake.addFirst(newBody);
                snake.removeLast();
            }

            // 방향 바꾸기
            if(resultTime == (key)) {
                if(value == 'D') {  // 오른쪽 회전
                    cur_idx = ((cur_idx + 4) -1 ) % 4;

                } else if(value == 'L') { // 원쪽 회전
                    cur_idx = (cur_idx + 1) % 4;

                }
                // key, value 업데이트
                if(!command.isEmpty()) {
                    nextCommad = command.poll();
                    key = nextCommad.keySet().iterator().next();    // 시간
                    value = nextCommad.get(key);    // 이동 방향  
                }
            }
        }

        System.out.println(resultTime);
        
        br.close();
    }

    static boolean ishitted(int[] newBody) {
        Iterator<int[]> iter = snake.iterator();
        while(iter.hasNext()) {
            int[] body = iter.next();
            if(body[0] == newBody[0] && body[1] == newBody[1]) {
                return true;
            }
        }
        return false;


    }
}
