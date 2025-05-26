import dk.sdu.cbse.common.services.IProcessService;
import dk.sdu.cbse.player.PlayerPlugin;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.player.PlayerProcess;

module Player {
    requires Common;
    provides IPluginService with PlayerPlugin;
    provides IProcessService with PlayerProcess;
}