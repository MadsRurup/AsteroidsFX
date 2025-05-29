
import dk.sdu.cbse.asteroid.AsteroidSplitter;
import dk.sdu.cbse.common.asteroid.IAsteroidSplitter;
import dk.sdu.cbse.common.services.IProcessorService;
import dk.sdu.cbse.asteroid.AsteroidPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.asteroid.AsteroidProcessor;

module Asteroid {
    requires Common;
    requires CommonAsteroid;
    provides IPluginService with AsteroidPlugin;
    provides IProcessorService with AsteroidProcessor;
    provides IAsteroidSplitter with AsteroidSplitter;
}