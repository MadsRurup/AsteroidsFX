import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.services.IProcessorService;
import dk.sdu.cbse.player.PlayerPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.player.PlayerProcessor;

module Player {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IPluginService with PlayerPlugin;
    provides IProcessorService with PlayerProcessor;
}