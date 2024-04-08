package coding_test_study;

import java.io.*;
import java.util.*;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        queue.add(lectures[0].end);     // 배정된 강의의 종료 시간을 저장

        for (int i = 1; i < n; i++) {
            if (queue.peek() <= lectures[i].start) {
                queue.poll();
            }
            queue.add(lectures[i].end);
        }

        System.out.println(queue.size());

        br.close();
    }
}

class Lecture {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}