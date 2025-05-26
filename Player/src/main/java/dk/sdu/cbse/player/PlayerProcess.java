package dk.sdu.cbse.player;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.GameInput;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IProcessService;

import java.util.ArrayList;
import java.util.List;

public class PlayerProcess implements IProcessService {
    @Override
    public void process(GameData gameData, World world) {
        int speed = 1;
        List<Entity> players = world.getEntities(Player.class);
        for (Entity player: players) {
            GameInput gameInput = gameData.getGameInput();
            if (gameInput.isPressed(gameInput.getKeyNumber("D"))) {
                player.setRotation(player.getRotation() + 1);
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("A"))) {
                player.setRotation(player.getRotation() - 1);
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("W"))) {
                double diffX = -1 * speed * Math.cos(Math.toRadians(player.getRotation()));
                double diffY = -1 * speed * Math.sin(Math.toRadians(player.getRotation()));
                player.setX(diffX + player.getX());
                player.setY(diffY + player.getY());
            }
            if (gameInput.isPressed(gameInput.getKeyNumber("S"))) {
                double diffX = speed * Math.cos(Math.toRadians(player.getRotation()));
                double diffY = speed * Math.sin(Math.toRadians(player.getRotation()));
                player.setX(diffX + player.getX());
                player.setY(diffY + player.getY());
            }

        }
    }
}
