import java.util.*;

public class BOJ14888 {
    static int n;
    static List<Integer> numbers;
    static List<String> operatorList = new ArrayList<>();
    static int[] operators;
    static String[] result;
    static boolean[] isused;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(input.nextInt());
        }

        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = input.nextInt();
            if(operators[i] > 0) {
                if (i == 0) {
                    for (int k = 0; k < operators[i]; k++)
                        operatorList.add("+");
                } else if (i == 1) {
                    for (int k = 0; k < operators[i]; k++)
                        operatorList.add("-");
                } else if (i == 2) {
                    for (int k = 0; k < operators[i]; k++)
                        operatorList.add("*");
                } else if (i == 3) {
                    for (int k = 0; k < operators[i]; k++)
                        operatorList.add("/");
                } 
            }
            
        }

        result = new String[operatorList.size()];
        isused = new boolean[operatorList.size()];

        fun(0);

        System.out.println(max);
        System.out.println(min);

        input.close();
    }

    static void fun(int k) {
        if (k == result.length) {
            // 계산하기
            // for(int j = 0; j < result.length; j++) {
            //     System.out.print(result[j] + " ");
            // }
            int calResult = cal(numbers, result);
            //System.out.println(calResult);

            if (calResult > max)
                max = calResult;
            if(calResult < min)
                min = calResult;
        }

        for (int i = 0; i < operatorList.size(); i++) {
            if(!isused[i]) {
                result[k] = operatorList.get(i);
                isused[i] = true;
                fun(k+1);
                isused[i] = false;
            }
            
        }

    }

    // numbers 크기는 항상 result의 크기 + 1 이다.
    static int cal(List<Integer> numbers, String[] result) {
        int calResult = numbers.get(0);

        for(int i = 0; i < result.length; i++) {
            switch (result[i]) {
                case "+":
                    calResult += numbers.get(i+1);
                    break;
                case "-":
                    calResult -= numbers.get(i+1);
                    break;
                case "*":
                    calResult *= numbers.get(i+1);
                    break;
                case "/":
                    calResult /= numbers.get(i+1);
                    break;
                default:
                    break;
            }
        }

        return calResult;
    }
}
