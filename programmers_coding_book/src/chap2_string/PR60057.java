package chap2_string;

import java.util.*;

public class PR60057 {
    public static void main(String[] args) {
        String input = "abcabcdede";
        System.out.println(solution(input));
    }

    public static int solution(String s) {
        int minResult = s.length();
        int answer = 0;
        for (int i = 1; i <= s.length(); i++) {
            List<String> strArr = split(s, i);
            answer = compress(strArr);
            minResult = Math.min(minResult, answer);

        }
        return minResult;
    }

    // 문자열 압출하고, 압축된 문자열의 길이를 반환하는 메소드
    private static int compress(List<String> source) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String last = "";
        for(String token : source) {
            if(token.equals(last)) {
                count++;
            } else {
                if(count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if(count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }

    private static List<String> split (String s, int length) {
        List<String> strArr = new LinkedList<>();
        for(int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if(endIndex > s.length()) endIndex = s.length();
            strArr.add(s.substring(startIndex, endIndex));
        }
        return strArr;
    }
}
