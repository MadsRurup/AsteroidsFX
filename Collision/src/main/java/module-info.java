import dk.sdu.cbse.collision.CollisionDetection;
import dk.sdu.cbse.common.asteroid.IAsteroidSplitter;
import dk.sdu.cbse.common.services.IPostProcessorService;

module Collision {
    requires Common;
    requires CommonAsteroid;
    provides IPostProcessorService with CollisionDetection;
    uses IAsteroidSplitter;
}