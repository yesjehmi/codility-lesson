package lessons;

import java.util.Arrays;

public class Codility2 {
    public int solution(int[] A) {
        if (A.length ==1) return A[0];
        Arrays.sort(A);

        int cnt = 0;

        while (cnt < A.length-1) {
            if (A[cnt] != A[cnt+1])
                return A[cnt];

            cnt = cnt+2;
        }

        return A[A.length-1];
    }

        /*
        int elem = 0;

        for (int i = 0; i < A.length; i++) {
            //elem ^= A[i];

            elem = elem ^ A[i];
        }
        return elem;*/
}
//9,3,9,3,9,7,9
//3,3,7,9,9,9,9

/*

1 7 13 15 16 27 29 88 3

27 1 13 3 15 29 88 16 16 1 27 13 15 29 88

1,3,7,13,15,16,27,*/
