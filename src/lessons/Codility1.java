package lessons;

public class Codility1 {

    public int solution(int N) {
        // write your code in Java SE 8
        int totalMax = 0;
        int zeroLength = 0;

        StringBuffer binaryNum = makeBinaryNum(N);

        for (int i=0; i<binaryNum.length(); i++) {
            if ('0' == binaryNum.charAt(i)) {
                zeroLength ++;
            } else {
                if (i!=0 && binaryNum.charAt(i-1)=='0') {
                    totalMax = totalMax < zeroLength ? zeroLength : totalMax;
                }

                zeroLength = 0;
            }
        }
        return totalMax;
    }

    private StringBuffer makeBinaryNum (int num) {
        StringBuffer binaryNum = new StringBuffer();
        StringBuffer newBinaryNum = new StringBuffer();

        while (num > 0) {
            binaryNum.append(num%2);
            num = num / 2;
        }

        for (int i= binaryNum.length()-1; i>=0 ; i--) {
            newBinaryNum.append(binaryNum.charAt(i));
        }
        return newBinaryNum;
    }
}
