package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.asteroid.Asteroid;
import dk.sdu.cbse.common.asteroid.IAsteroidSplitter;

import java.util.ArrayList;
import java.util.Random;

public class AsteroidSplitter implements IAsteroidSplitter {


    @Override
    public void createSplitAsteroids(Entity parent, Entity other, World world) {
        Asteroid parentA = (Asteroid) parent;
        ArrayList<Asteroid> list = new ArrayList<>();
        Asteroid asteroid = new Asteroid();

        Random random = new Random();
        double[] coords = {0,28,37,0,74,28,60,74,14,74};
        asteroid.setScale(parentA.getScale()/2);
        double[] scaledCoords = new double[coords.length];
        if (asteroid.getScale() < 0.5) {
            return;
        }
        for (int i = 0; i < coords.length; i++) {
            scaledCoords[i] = coords[i]*asteroid.getScale();
        }
        asteroid.setPolygonCoordinates(scaledCoords);
        asteroid.normalizePolygon();

        Asteroid asteroid1 = new Asteroid();
        asteroid1.setScale(parentA.getScale()/2);
        asteroid1.setPolygonCoordinates(scaledCoords);
        asteroid1.normalizePolygon();

        asteroid.setRotation(other.getRotation()-90);
        asteroid1.setRotation(other.getRotation()+90);
        float speed = 0.5f;
        //Asteroid 1
        double diffX = 1 * Math.cos(Math.toRadians(asteroid.getRotation()))*asteroid.getRadius();
        double diffY = 1 * Math.sin(Math.toRadians(asteroid.getRotation()))*asteroid.getRadius();
        asteroid.setX(parent.getX()+ diffX);
        asteroid.setY(parent.getY()+ diffY);
        //Asteroid 2
        diffX = 1 * Math.cos(Math.toRadians(asteroid1.getRotation()))*asteroid1.getRadius();
        diffY = 1 * Math.sin(Math.toRadians(asteroid1.getRotation()))*asteroid1.getRadius();
        asteroid1.setX(parent.getX()+ diffX);
        asteroid1.setY(parent.getY()+ diffY);

        list.add(asteroid);
        list.add(asteroid1);

        for (Asteroid a : list) {
            world.addEntity(a);
        }
    }
}
