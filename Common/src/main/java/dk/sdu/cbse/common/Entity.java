package dk.sdu.cbse.common;
import dk.sdu.cbse.common.geometry.Circle;
import dk.sdu.cbse.common.geometry.Point;
import dk.sdu.cbse.common.geometry.RadiusCalculation;

import java.util.ArrayList;
import java.util.UUID;

public class Entity {
    private final UUID ID = UUID.randomUUID();

    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private float radius;
    private float moveSpeed;
    private float rotationSpeed;

    public Entity() {
    }


    public String getID() {
        return ID.toString();
    }


    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }


    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }


    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }
    public void setRotationSpeed(float rotationSpeed){
        this.rotationSpeed = rotationSpeed;
    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }

    public void normalizePolygon() {
        double[] polygon = getPolygonCoordinates().clone();
        RadiusCalculation rc = new RadiusCalculation();
        ArrayList<Point> points = rc.getPoints(polygonCoordinates);
        Circle circle = rc.approximateCircle(points);

        double offSetX = circle.c.x;
        double offSetY = circle.c.y;
        for (int i = 0; i < points.size(); i++) {
            polygon[i*2] -= offSetX;
            polygon[i*2+1] -= offSetY;
        }
        setRadius((float) circle.r);
        setPolygonCoordinates(polygon);
    }

    public void calcRadius() {
        RadiusCalculation rc = new RadiusCalculation();
        //rc.setPolygonCoordinates(getPolygonCoordinates());
        //Circle circle = rc.approximateCircle(rc.getPoints(getPolygonCoordinates()));
        //setRadius((float) circle.r);
        //System.out.println(circle.r +" " + circle.c.x + " " + circle.c.y);
    }



}
