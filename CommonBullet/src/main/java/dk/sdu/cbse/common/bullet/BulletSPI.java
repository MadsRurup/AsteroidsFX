package dk.sdu.cbse.common.bullet;

import dk.sdu.cbse.common.Entity;

public interface BulletSPI {
    public Bullet createBullet(Entity shooter);
}
