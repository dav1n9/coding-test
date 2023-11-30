package chap2_string;

public class PR12926 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) sb.append(c);
            else {
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                int position = c - offset;
                position = (position + n) % ('Z'- 'A' +1 );
                sb.append((char)(offset + position));

            }
        }
        return sb.toString();
    }

    // 위의 처럼 offset 을 구해서 계산하는 방식이 더 간단하고,
    // 중복코드를 줄일 수 있음. ('z' -> 'a' 또는 'Z' -> 'A' 가는 방법 동일)

    // 또한 문자열의 모든 문자에 대해 반복할 때,
    // 인덱스 접근보다 toCharArray 사용하기
    public String solution2(String s, int n) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(Character.isUpperCase(arr[i])) {
                int upper = arr[i] + n;
                if(upper > 'Z') {
                    upper -= ('Z'+ 1);
                    upper += 'A';
                }
                arr[i] = (char) upper;
            } else if (Character.isLowerCase(arr[i])) {
                int lower = arr[i] + n;
                if(lower > 'z') {
                    lower -= ('z'+ 1);
                    lower += 'a';
                }
                arr[i] = (char) lower;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
