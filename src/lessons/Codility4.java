package lessons;

import java.util.Arrays;

public class Codility4 {
    public int solution(int[] A) {
        Arrays.sort(A);
        if (A[A.length-1] == A.length && Arrays.stream(A).sum() == intArraySum(A.length)) return 1;
        else return 0;
    }

    private int intArraySum(int length) {
        int sum = 0;
        for (int count =1; count <=length; count++) {
            sum = sum + count;
        }

        return sum;
    }
}

