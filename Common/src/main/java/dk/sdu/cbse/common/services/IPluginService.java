package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;

public interface IPluginService {
    public void start(GameData gameData, World world);
    public void stop(GameData gameData, World world);
}
