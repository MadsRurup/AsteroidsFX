import dk.sdu.cbse.common.services.IProcessorService;

module Core {
    uses dk.sdu.cbse.common.services.IPluginService;
    uses IProcessorService;
    uses dk.sdu.cbse.common.services.IPostProcessorService;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires Common;
    exports dk.sdu.cbse;
}