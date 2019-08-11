package lessons;

public class Codility2_2 {
    public int[] solution(int[] A, int K) {
        if (A.length == 0 || K == 0) return A;

        int shiftCount = K % A.length;
        int[] newArray = new int[A.length];

        for (int i = 0; i < A.length; i ++) {
            newArray[(i+shiftCount)% A.length] = A[i];
        }

        return newArray;
    }
}

