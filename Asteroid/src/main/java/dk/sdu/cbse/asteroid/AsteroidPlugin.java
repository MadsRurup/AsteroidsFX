package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IPluginService;

import java.util.Random;

public class AsteroidPlugin implements IPluginService {


    @Override
    public void start(GameData gameData, World world) {
        world.addEntity(createAsteroid(gameData));
        System.out.println("Asteroid loaded");
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
    private Asteroid createAsteroid(GameData gameData) {
        Asteroid asteroid = new Asteroid();
        Random random = new Random();
        double[] coords = {0,28,37,0,74,28,60,74,14,74};
        asteroid.setPolygonCoordinates(coords);
        asteroid.normalizePolygon();
        asteroid.calcRadius();
        asteroid.setX(random.nextInt(gameData.getWidth()));
        asteroid.setY(random.nextInt(gameData.getHeight()));
        asteroid.setRotation(random.nextInt(360));
        return asteroid;
    }
}
