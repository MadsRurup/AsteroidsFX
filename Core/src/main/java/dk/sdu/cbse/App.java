package dk.sdu.cbse;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.common.services.IProcessService;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.ServiceLoader;


public class App extends Application {

    private final Pane gameWindow = new Pane();
    public static void main(String[] args) {
        System.out.println("Hello World");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        GameData gameData = new GameData();
        World world = new World();
        gameData.initialize(stage);
        for (IPluginService service : getPluginServices()) {
            service.start(gameData,world);
            System.out.println("Plugin Service loaded");
        }

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (IProcessService service : getProcessService()) {
                    service.process(gameData,world);

                }
                gameData.draw(world);

            }

        }.start();



    }

    private ServiceLoader<IPluginService> getPluginServices() {
        return ServiceLoader.load(IPluginService.class);
    }
    private ServiceLoader<IProcessService> getProcessService() {
        return ServiceLoader.load(IProcessService.class);
    }



}