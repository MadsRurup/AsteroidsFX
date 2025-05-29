package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.GameInput;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessingService;

import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;

public class EnemyProcessing implements IProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        float speed = 0.5f;
        float rotationSpeed = 0.5f;
        List<Entity> enemys = world.getEntities(Enemy.class);
        for (Entity entity : enemys) {
            Enemy enemy = (Enemy) entity;
            GameInput gameInput = gameData.getGameInput();
            Random random = new Random();
            //System.out.println("RotationTime: " + enemy.rotationTime + " Direction : " + enemy.rotateDirection);
            if (enemy.rotationTime == 0) {
                enemy.rotationTime = random.nextInt(10, 200);
                switch (random.nextInt(3)) {
                    case 0:
                        enemy.rotateDirection = RotateDirection.LEFT;
                        break;
                    case 1:
                        enemy.rotateDirection = RotateDirection.NONE;
                        break;
                    case 2:
                        enemy.rotateDirection = RotateDirection.RIGHT;
                        break;
                }
            }
            switch (enemy.rotateDirection) {
                case LEFT:
                    enemy.setRotation(enemy.getRotation() + rotationSpeed);
                    break;
                case NONE:
                    enemy.setRotation(enemy.getRotation());
                    break;
                case RIGHT:
                    enemy.setRotation(enemy.getRotation() - rotationSpeed);
                    break;

            }
            enemy.rotationTime--;
            double diffX = 1 * speed * Math.cos(Math.toRadians(enemy.getRotation()));
            double diffY = 1 * speed * Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(diffX + enemy.getX());
            enemy.setY(diffY + enemy.getY());
            if (enemy.shootTime == 0) {
                //Chance to begin shooting
                if (random.nextInt(1000) < 2) {
                    // Min and Max shoot time
                    enemy.shootTime = random.nextInt(30, 180);
                }
            } else {
                int timeBetweenBullets = 20;
                if (enemy.shootTime % timeBetweenBullets == 0) {
                    world.addEntity(getBulletSPIs().findFirst().get().createBullet(enemy));
                }
                enemy.shootTime--;
            }


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
    private ServiceLoader<BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class);
    }
}
