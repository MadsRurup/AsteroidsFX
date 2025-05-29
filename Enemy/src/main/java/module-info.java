import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessService;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.enemy.EnemyProcess;

module Enemy {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IPluginService with EnemyPlugin;
    provides IProcessService with EnemyProcess;
}