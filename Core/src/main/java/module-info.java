import dk.sdu.cbse.common.services.IProcessorService;

module Core {
    uses dk.sdu.cbse.common.services.IPluginService;
    uses IProcessorService;
    uses dk.sdu.cbse.common.services.IPostProcessorService;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    opens dk.sdu.cbse to spring.core, spring.beans, spring.context;
    requires Common;
    exports dk.sdu.cbse;
}