import dk.sdu.cbse.common.services.IProcessingService;

module Core {
    uses dk.sdu.cbse.common.services.IPluginService;
    uses IProcessingService;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires Common;
    exports dk.sdu.cbse;
}