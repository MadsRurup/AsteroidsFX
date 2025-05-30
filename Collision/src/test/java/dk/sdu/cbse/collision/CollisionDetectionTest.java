package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.Entity;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;


public class CollisionDetectionTest {
    @Test
    public void testCollision() {
        CollisionDetection detector = new CollisionDetection();
        Entity e1 = new Entity();
        e1.setRadius(2);
        e1.setX(0);
        e1.setY(0);
        Entity e2 = new Entity();
        e2.setRadius(3);
        e2.setX(4);
        e2.setY(1);
        assertTrue(detector.collides(e1,e2));
    }
}
