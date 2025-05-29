package dk.sdu.cbse.common.geometry;

import java.util.ArrayList;

public class RadiusCalculation {
    double[] polygonCoordinates;
    public void setPolygonCoordinates(double[] polygonCoordinates){
        this.polygonCoordinates = polygonCoordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }


    // True pain
    public Point circleCenter(Point A, Point B, Point C) {
        double D = 2 * (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y));
        return new Point(
                ((A.x*A.x + A.y*A.y) * (B.y - C.y) + (B.x*B.x + B.y*B.y) * (C.y - A.y) + (C.x*C.x + C.y*C.y) * (A.y - B.y)) / D,
                -((A.x*A.x + A.y*A.y) * (B.x - C.x) + (B.x*B.x + B.y*B.y) * (C.x - A.x) + (C.x*C.x + C.y*C.y) * (A.x - B.x)) / D
        );
    }

    public double circleRadius(Point A, Point B, Point C) {
        double x1 = A.x, y1 = A.y;
        double x2 = B.x, y2 = B.y;
        double x3 = C.x, y3 = C.y;

        double D = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        double a = ((x1*x1 + y1*y1) * (y2 - y3) + (x2*x2 + y2*y2) * (y3 - y1) + (x3*x3 + y3*y3) * (y1 - y2)) / D;
        double b = ((x1*x1 + y1*y1) * (x3 - x2) + (x2*x2 + y2*y2) * (x1 - x3) + (x3*x3 + y3*y3) * (x2 - x1)) / D;
        double r = Math.sqrt((x1 - a) * (x1 - a) + (y1 - b) * (y1 - b));
        System.out.println("Radius" + r);
        return r;
    }
    public ArrayList<Point> getPoints(double... polygonCoordinates) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < polygonCoordinates.length/2; i++) {
            Point point = new Point();
            point.x = polygonCoordinates[i*2];

            point.y = polygonCoordinates[i*2+1];

            points.add(point);
        }
        return points;
    }


    public Point getCentroid(ArrayList<Point> points) {
        double sumX = 0, sumY = 0;
        for (Point p : points) {
            sumX += p.x;
            sumY += p.y;
        }
        int n = points.size();
        Point centroid = new Point(sumX / n, sumY / n);
        return centroid;
    }

    public Circle approximateCircle(ArrayList<Point> points) {
        Point centroid = getCentroid(points);

        double maxDist = 0;
        for (Point p : points) {
            double dx = p.x - centroid.x;
            double dy = p.y - centroid.y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist > maxDist) {
                maxDist = dist;
            }
        }

        return new Circle(centroid, maxDist);
    }

    /*public Circle getSmallest() {

        ArrayList<Point> look = getPoints();
        ArrayList<Point> currentPoints = new ArrayList<>();
        currentPoints.add(look.get(0));
        currentPoints.add(look.get(1));
        currentPoints.add(look.get(2));
        double firstR = circleRadius(look.get(0),look.get(1),look.get(2));
        Point firstC = circleCenter(look.get(0),look.get(1),look.get(2));
        Circle smallest = new Circle(firstC,firstR);

        look.removeAll(currentPoints);

        for (int i = 0; i < look.size(); i++) {
            double r = circleRadius(look.get(i),currentPoints.get(1),currentPoints.get(2));
            Point c = circleCenter(look.get(i),currentPoints.get(1),currentPoints.get(2));



            //double r = circleRadius(look.get(i),look.get(i+1),look.get(i+2));
            //Point c = circleCenter(look.get(i),look.get(i+1),look.get(i+2));
            double distance = Math.sqrt(Math.pow((smallest.c.x - c.x),2)+Math.pow((smallest.c.y - c.y),2));
            if (distance > r) {

            }
        }
        return smallest;
    }*/

}