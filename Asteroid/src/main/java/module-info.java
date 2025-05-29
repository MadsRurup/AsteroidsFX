
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.asteroid.AsteroidPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.asteroid.AsteroidProcessing;

module Asteroid {
    requires Common;
    provides IPluginService with AsteroidPlugin;
    provides IProcessingService with AsteroidProcessing;
}