package dk.sdu.cbse.player;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.GameInput;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessorService;

import java.util.List;
import java.util.ServiceLoader;

public class PlayerProcessor implements IProcessorService {
    @Override
    public void process(GameData gameData, World world) {
        int speed = 1;
        List<Entity> players = world.getEntities(Player.class);
        for (Entity entity: players) {
            Player player = (Player) entity;

            GameInput gameInput = gameData.getGameInput();
            //System.out.println("X: " + player.getX() + " Y: " + player.getY() + " Rotation: " + player.getRotation());
            if (gameInput.isPressed(gameInput.getKeyNumber("D"))) {
                player.setRotation(player.getRotation() + 1);
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("A"))) {
                player.setRotation(player.getRotation() - 1);
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("W"))) {
                double diffX = 1 * speed * Math.cos(Math.toRadians(player.getRotation()));
                double diffY = 1 * speed * Math.sin(Math.toRadians(player.getRotation()));
                player.setX(diffX + player.getX());
                player.setY(diffY + player.getY());
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("S"))) {
                double diffX = -speed * Math.cos(Math.toRadians(player.getRotation()));
                double diffY = -speed * Math.sin(Math.toRadians(player.getRotation()));
                player.setX(diffX + player.getX());
                player.setY(diffY + player.getY());
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("SPACE"))) {
                if (player.shotsFired % 50 == 0) {
                    world.addEntity(getBulletSPIs().findFirst().get().createBullet(player));
                }
                player.shotsFired++;
                //System.out.println(getBulletSPIs().stream().count());
            } else {
                player.shotsFired = 0;
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
