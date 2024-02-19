package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());    
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(num, i));
        }

        System.out.print(1 + " ");
        Balloon balloon = deque.pollFirst(); // 첫번째 엘리먼트 제거 후 리턴
        while (!deque.isEmpty()){
            // idx 이동
            if(balloon.getNumber() > 0) { // 오른쪽 이동
                for(int i = 0; i < (balloon.getNumber()-1); i++) {
                    deque.addLast(deque.pollFirst());
                }
                balloon = deque.pollFirst();
            } else {    // 왼쪽 이동
                for(int i = 0; i < (Math.abs(balloon.getNumber()+1)); i++) {
                    deque.addFirst(deque.pollLast());
                }
                balloon = deque.pollLast();
            }

            // write 하기
            System.out.print(balloon.getIndex() + " ");
        }

        br.close();
    }
}

class Balloon {
    int number;
    int index;

    public Balloon(int num, int idx) {
        number = num;
        index = idx;
    }

    public int getNumber() {
        return number;
    }
    public int getIndex() {
        return index;
    }
}
