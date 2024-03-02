package coding_test_study;

import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int k = input.nextInt();
        for(int i = 0; i < k; i++) {

            Queue<Importance> queue = new LinkedList<>();
            ArrayList<Integer> imps = new ArrayList<>();

            int n = input.nextInt();
            int idx = input.nextInt();
            int maxImp = 0;

            // n만큼 중요도를 입력받아 큐에 저장
            for(int j = 0; j < n; j++) {
                int importance = input.nextInt();
                imps.add(importance);
                queue.add(new Importance(importance, j));
            }

            maxImp = Collections.max(imps);
            int count = 0;
            boolean done = false;
            while(!done) {
                Importance front = queue.remove();
                if(front.number == maxImp) {
                    count++;
                    if(front.index == idx) {
                        System.out.println(count);
                        done = true;
                        break;
                    }
                    imps.remove(imps.indexOf(maxImp));
                    maxImp = Collections.max(imps);
                } else {
                    queue.add(front);
                }
            }
        }

        input.close();
    }
}

class Importance {
    int number;
    int index;

    Importance(int n, int idx) {
        number = n;
        index = idx;
    }
}
