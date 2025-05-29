package dk.sdu.cbse.common.asteroid;
import dk.sdu.cbse.common.Entity;


public class Asteroid extends Entity {
    private float scale = 1;

    public void setScale(float scale) {
        this.scale = scale;
    }
    public float getScale(){
        return this.scale;
    }
}
