import dk.sdu.cbse.bullet.BulletProcessor;
import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessorService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides BulletSPI with BulletProcessor;
    provides IProcessorService with BulletProcessor;
}