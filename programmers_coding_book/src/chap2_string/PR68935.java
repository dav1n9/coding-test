package chap2_string;

public class PR68935 {
    public int solution(int n) {
        String num_3 = Integer.toString(n, 3);

        StringBuilder st = new StringBuilder(num_3).reverse();

        return Integer.valueOf(st.toString(), 3);
    }
}
