
import dk.sdu.cbse.common.services.IProcessService;
import dk.sdu.cbse.asteroid.AsteroidPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.asteroid.AsteroidProcess;

module Asteroid {
    requires Common;
    provides IPluginService with AsteroidPlugin;
    provides IProcessService with AsteroidProcess;
}