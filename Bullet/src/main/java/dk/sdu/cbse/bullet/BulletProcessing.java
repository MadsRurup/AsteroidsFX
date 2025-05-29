package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.bullet.Bullet;
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.common.bullet.BulletSPI;

import java.util.List;

public class BulletProcessing implements IProcessingService, BulletSPI {
    private float speed = 5;

    @Override
    public void process(GameData gameData, World world) {
        List<Entity> entitys = world.getEntities(Bullet.class);
        for (Entity entity : entitys) {
            Bullet bullet = (Bullet) entity;
            double diffX = 1 * speed * Math.cos(Math.toRadians(entity.getRotation()));
            double diffY = 1 * speed * Math.sin(Math.toRadians(entity.getRotation()));
            entity.setX(diffX + entity.getX());
            entity.setY(diffY + entity.getY());

            if (entity.getX()-entity.getRadius() > gameData.getWidth()) {
                entity.setX(-entity.getRadius());
                bullet.bulletLoopCount++;
            } else if (entity.getX()+entity.getRadius() < 0) {
                entity.setX(entity.getRadius()+gameData.getWidth());
                bullet.bulletLoopCount++;
            }
            if (entity.getY()-entity.getRadius() > gameData.getHeight()) {
                bullet.bulletLoopCount++;
                entity.setY(-entity.getRadius());
            } else if (entity.getY()+entity.getRadius() < 0) {
                entity.setY(entity.getRadius()+gameData.getHeight());
                bullet.bulletLoopCount++;
            }
            int loopLimit = 0;
            if (bullet.bulletLoopCount > loopLimit) {
                world.removeEntity(bullet);
            }
        }
    }

    @Override
    public Bullet createBullet(Entity shooter) {
        Bullet bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        bullet.setRotation(shooter.getRotation());
        bullet.calcRadius();
        bullet.normalizePolygon();
        double changeX = Math.cos(Math.toRadians(shooter.getRotation()));
        double changeY = Math.sin(Math.toRadians(shooter.getRotation()));
        bullet.setX(shooter.getX() + changeX * (shooter.getRadius()+bullet.getRadius()));
        bullet.setY(shooter.getY() + changeY * (shooter.getRadius()+bullet.getRadius()));

        return bullet;
    }
}
