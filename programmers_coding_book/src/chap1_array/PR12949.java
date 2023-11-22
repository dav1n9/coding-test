package chap1_array;
public class PR12949 {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};
        int[][] result = solution(arr1, arr2);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < answer.length; ++i) {
            for(int j = 0; j < answer[i].length; ++j) {
                answer[i][j] = 0;

                for(int k = 0; k < arr1[0].length; ++k) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}

