import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.player.PlayerPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.player.PlayerProcessing;

module Player {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IPluginService with PlayerPlugin;
    provides IProcessingService with PlayerProcessing;
}