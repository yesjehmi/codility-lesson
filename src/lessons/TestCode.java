package lessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestCode {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elementCount = Integer.parseInt(br.readLine());
        Point[] points = new Point[elementCount];

        for (int i = 0; i < elementCount; i++) {
            String[] input = br.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        boolean flag = false;

        for (int i = 0; i < elementCount; i++) {
            boolean[] marked = new boolean[elementCount];
            Point point = points[i];
            marked[point.getX()] = true;
            while (true) {
                if (point.getY() >= elementCount) {
                    break;
                }

                if (marked[point.getY()]) {
                    System.out.println("true");
                    flag = true;
                    break;
                }

                marked[point.getY()] = true;
                point = points[point.getY()];
            }

            if (flag) break;
        }

        if(!flag)
            System.out.println("false");
    }

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }
}
