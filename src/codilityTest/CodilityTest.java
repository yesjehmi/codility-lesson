package codilityTest;

import java.util.*;

public class CodilityTest {

    //split array with 3 pieces
    public int solution(int[] A) {
        int N = A.length;
        int result = 0;

        List<Number> numbers = Number.arrayToList(Arrays.copyOfRange(A, 1, N));
        Collections.sort(numbers);

        for (int i=1; i<numbers.size(); i++) {
            if (Math.abs(numbers.get(0).getIndex()-numbers.get(i).getIndex()) !=1)
                return numbers.get(0).getNumber() + numbers.get(i).getNumber();
        }

        return result;
    }
}


class Number implements Comparable<Number>{

    private int index;
    private int number;

    public Number(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public static List<Number> arrayToList (int[] A) {
        List<Number> numbers = new ArrayList<>();
        for (int i=0; i < A.length; i++) {
            numbers.add(new Number(i, A[i]));
        }
        return numbers;
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {return number;}

    @Override
    public int compareTo(Number o) {
        if (this.number > o.number)
            return 1;
        else if (this.number < o.number)
            return -1;
        return 0;
    }
}
