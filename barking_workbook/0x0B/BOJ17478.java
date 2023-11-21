import java.util.*;

public class BOJ17478 {

    public static final String Q1 = "\"재귀함수가 뭔가요?\"";
    public static final String QQ2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    public static final String QQ3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    public static final String QQ4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    public static final String A1 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    public static final String A2 = "라고 답변하였지.";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        answer(n, 0);
        input.close();
    }

    public static void answer(int n, int i) {
        if (n == 0) {
            String s = "";
            for (int a = 0; a < 4 * i; a++) {
                s += "_";
            }
            System.out.println(s+Q1);
            System.out.println(s+A1);
        } else {
            String s = "";
            for (int a = 0; a < 4 * i; a++) {
                s += "_";
            }
            System.out.println(s + Q1);
            System.out.println(s + QQ2);
            System.out.println(s + QQ3);
            System.out.println(s + QQ4);
            answer(n - 1, i+1);
        }
        String s = "";
        for (int a = 0; a < 4 * i; a++) {
            s += "_";
        }
        System.out.println(s + A2);

    }
}
