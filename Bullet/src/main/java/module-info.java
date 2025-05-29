import dk.sdu.cbse.bullet.BulletProcess;
import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides BulletSPI with BulletProcess;
    provides IProcessService with BulletProcess;
}