import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13335 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int w = input.nextInt();
        int L = input.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(input.nextInt());
        }

        int resultTime = 0;

        // 다리 위의 트럭의 무게를 계산해야 함.
        Queue<Integer> onBridge = new LinkedList<>(); // 크기 = w로 유지.
        int onBridgeWeight = 0;
        for (int i = 0; i < w; i++) {
            onBridge.add(0);
        }

        // 앞 트럭 지우면서 새로운 트럭 추가
        // 다음 트럭 들어간다고 할 때, 다리 위의 무게가 L을 넘으면 0 추가

        // L 이하이면 다음 트럭 추가

        // (다음 들어갈 트럭이 없으면 추가x)
        // queue.size() 가 0이면(다음 트럭 없으면), 그냥 다리위 남은 트럭 삭제
        // onBridge 까지 사라지면 종료
        while (!onBridge.isEmpty()) {
            if (queue.isEmpty()) {
                onBridge.remove();
            } else {
                int nextTruck = queue.peek();
                int remove = onBridge.peek();

                if (onBridgeWeight + nextTruck - remove > L) {
                    nextTruck = 0;
                } else {
                    queue.remove();
                }
                onBridge.add(nextTruck);
                remove = onBridge.poll();
                onBridgeWeight -= remove;
                onBridgeWeight += nextTruck;
            }
            resultTime++;
        }

        System.out.println(resultTime);

        input.close();
    }
}
