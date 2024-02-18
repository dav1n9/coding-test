package chap2_string;

public class PR70129 {

    static int removeZeroCount = 0;
    public static void main(String[] args) {
        String input = "110010101001";
        int[] result = solution(input);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String s) {
        int[] answer;
        int count = 0;
        while(s.length() > 1) {
            count++;
            s = Integer.toString(count1(s), 2);
        }

        answer = new int[] {count, removeZeroCount};
        return answer;
    }

    private static int count1(String s)
    {
        int countOne = 0;
        for(char c : s.toCharArray()) {
            if (c == '1') countOne++;
            else if(c == '0') removeZeroCount++;
        }
        return countOne;
    }
}
