package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.enemy.Enemy;

import java.util.Random;

public class EnemyPlugin implements IPluginService {


    @Override
    public void start(GameData gameData, World world) {
        world.addEntity(createEnemy(gameData));
        System.out.println("Enemy loaded");

    }

    @Override
    public void stop(GameData gameData, World world) {

    }
    private Enemy createEnemy(GameData gameData) {
        Enemy enemy = new Enemy();
        Random random = new Random();
        double[] coords = {0,0,34,12,0,24,9,12};
        enemy.setPolygonCoordinates(coords);
        enemy.normalizePolygon();
        enemy.calcRadius();
        enemy.setX(random.nextInt(gameData.getWidth()));
        enemy.setY(random.nextInt(gameData.getHeight()));
        enemy.setRotation(random.nextInt(161));
        return enemy;
    }
}
