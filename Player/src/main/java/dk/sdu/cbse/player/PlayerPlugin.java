package dk.sdu.cbse.player;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.player.Player;

public class PlayerPlugin implements IPluginService {


    @Override
    public void start(GameData gameData, World world) {
        world.addEntity(createPlayer(gameData));
        System.out.println("Player loaded");

    }

    @Override
    public void stop(GameData gameData, World world) {

    }
    private Player createPlayer(GameData gameData) {
        Player player = new Player();
        double[] coords = {0,0,0,50,50,50,50,0};
        player.setPolygonCoordinates(coords);
        player.setX((double) gameData.getWidth() /2);
        player.setY((double) gameData.getHeight() /2);
        return player;
    }
}
