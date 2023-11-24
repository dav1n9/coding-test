package chap2_string;

public class PR12932 {
    public int[] solution(long n) {
        int[] answer;

        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] c = reversed.toCharArray();

        answer = new int[c.length];
        for(int i = 0; i < c.length; i++) {
            answer[i] = c[i] -'0';
        }
        return answer;
    }
}
