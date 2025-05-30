package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.asteroid.Asteroid;
import dk.sdu.cbse.common.asteroid.IAsteroidSplitter;
import dk.sdu.cbse.common.services.IPostProcessorService;

import java.util.ArrayList;
import java.util.ServiceLoader;

public class CollisionDetection implements IPostProcessorService {
    @Override
    public void process(GameData gameData, World world) {

        ArrayList<Entity> asteroids = new ArrayList<>();
        ArrayList<Entity> others = new ArrayList<>();
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {
                if (entity1.equals(entity2)) {
                    continue;
                }
                if (collides(entity1, entity2)) {
                    world.removeEntity(entity1);
                    world.removeEntity(entity2);
                    if (entity1.getClass().equals(Asteroid.class) & getIAsteroidSplitter().findFirst().isPresent()) {
                        asteroids.add(entity1);
                        others.add(entity2);
                    }
                    if (entity2.getClass().equals(Asteroid.class) & getIAsteroidSplitter().findFirst().isPresent()) {
                        asteroids.add(entity2);
                        others.add(entity1);
                    }

                }
            }
        }
        for (int i = 0; i < asteroids.size(); i++) {
            getIAsteroidSplitter().findFirst().get().createSplitAsteroids(asteroids.get(i),others.get(i),world);
        }

    }


    public boolean collides(Entity entity1, Entity entity2) {
        double diffX = entity1.getX() - entity2.getX();
        double diffY = entity1.getY() - entity2.getY();
        // Overcomplicated
        //float distance = Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY,2);
        double distance = Math.sqrt(diffX * diffX + diffY * diffY);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

    private ServiceLoader<IAsteroidSplitter> getIAsteroidSplitter() {
        return ServiceLoader.load(IAsteroidSplitter.class);
    }
}
