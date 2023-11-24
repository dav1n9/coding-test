package chap2_string;

public class PR12930 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                sb.append(c);
                toUpper = true;
            } else {
                if(toUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return sb.toString();
    }

    public String solution2(String s) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for(char c : s.toCharArray()) {
            // 위의 코드처럼 그냥 c 자체를 추가해도 됨.
            // 이 문제에서는 알파벳이 아니면 공백이기 때문.
            if(!Character.isAlphabetic(c)) {
                sb.append(' ');
                index = 0;
            } else {
                if(index % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                index++;
            }

        }
        return sb.toString();
    }
}
