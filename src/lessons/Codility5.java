package lessons;

public class Codility5 {
    public int solution(int[] A)
    {
        int passingCar = 0;
        int totalCount = 0;

        for (int position : A) {
            if (position == 0) {
                passingCar++;
            }

            if (passingCar > 0) {
                if (position == 1) {
                    totalCount = totalCount + passingCar;
                    if (totalCount > 1_000_000_000) {
                        return -1;
                    }
                }
            }
        }

        return totalCount;
    }
}
