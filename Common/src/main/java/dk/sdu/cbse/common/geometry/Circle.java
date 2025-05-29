package dk.sdu.cbse.common.geometry;

public class Circle {
    public double r;
    public Point c;
    Circle() {}
    Circle(Point c, double r) {
        this.r = r;
        this.c = c;
    }
}
