package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.GameInput;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IProcessService;

import java.util.List;
import java.util.Random;

public class AsteroidProcess implements IProcessService {
    @Override
    public void process(GameData gameData, World world) {
        float speed = 0.5f;
        float rotationSpeed = 0.5f;
        List<Entity> asteroids = world.getEntities(Asteroid.class);
        for (Entity entity : asteroids) {
            Asteroid asteroid = (Asteroid) entity;
            GameInput gameInput = gameData.getGameInput();
            Random random = new Random();

            double diffX = 1 * speed * Math.cos(Math.toRadians(asteroid.getRotation()));
            double diffY = 1 * speed * Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(diffX + asteroid.getX());
            asteroid.setY(diffY + asteroid.getY());

            if (entity.getX()-entity.getRadius() > gameData.getWidth()) {
                entity.setX(-entity.getRadius());
            } else if (entity.getX()+entity.getRadius() < 0) {
                entity.setX(entity.getRadius()+gameData.getWidth());
            }
            if (entity.getY()-entity.getRadius() > gameData.getHeight()) {
                entity.setY(-entity.getRadius());
            } else if (entity.getY()+entity.getRadius() < 0) {
                entity.setY(entity.getRadius()+gameData.getHeight());
            }

        }
    }
}
