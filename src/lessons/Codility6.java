package lessons;

import java.util.Arrays;

public class Codility6 {
    public int solution(int[] A) {
        Arrays.sort(A);

        int compareNum1 = A[0] * A[1];
        int compareNum2 = A[A.length-1]*A[A.length-2];

        int multipleTotalNum;

        int lastIndex = A.length-1;

        if (compareNum1 > compareNum2) {
            multipleTotalNum = compareNum1;
        } else {
            multipleTotalNum = compareNum2;
            lastIndex = A.length-3;
        }

        if (A[A.length-1] < 0 && compareNum2 < compareNum1) {
            multipleTotalNum = compareNum2;
            lastIndex = A.length-3;
        }

        return multipleTotalNum * A[lastIndex];
    }
}
