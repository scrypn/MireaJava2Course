package Prac003.MathRandom;

import java.util.ArrayList;

class Point {
    private float x, y = 0;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

}

class Circle {
    Point center;
    ArrayList<Point> points = new ArrayList<>(16);

    Circle(float x, float y) {
        center = new Point(x, y);
    }

    public void addPoint(float x, float y) {
        points.add(new Point(x, y));
    }
}

public class Task002 {
    private static ArrayList<Circle> circles = new ArrayList<>(16);
    private static int size = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            circles.add(new Circle(34, 45));
            size++;
        }
    }
}
