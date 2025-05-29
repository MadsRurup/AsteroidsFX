import dk.sdu.cbse.bullet.BulletProcessing;
import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessingService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides BulletSPI with BulletProcessing;
    provides IProcessingService with BulletProcessing;
}