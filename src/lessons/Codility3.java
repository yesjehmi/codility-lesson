package lessons;

public class Codility3 {
    // 개구리는 현재 X 위치에 있으며 Y보다 크거나 같은 위치로 가고 싶어합니다. 작은 개구리는 항상 고정 된 거리 D를 점프합니다.
    public int solution(int X, int Y, int D) {
        int distance = Y-X;

        if (distance == 0) return 0;
        else if (distance % D == 0) return distance/D;
        else return distance/D+1;
    }
}

