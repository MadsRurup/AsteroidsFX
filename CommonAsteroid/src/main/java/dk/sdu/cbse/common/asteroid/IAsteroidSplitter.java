package dk.sdu.cbse.common.asteroid;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.World;

import java.util.ArrayList;

public interface IAsteroidSplitter {
    public void createSplitAsteroids(Entity entity, Entity other, World world);
}
