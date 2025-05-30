package dk.sdu.cbse;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.common.services.IPostProcessorService;
import dk.sdu.cbse.common.services.IProcessorService;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;
import java.util.ServiceLoader;


public class App {

    private final List<IPluginService> gamePluginServices;
    private final List<IProcessorService> entityProcessingServiceList;
    private final List<IPostProcessorService> postEntityProcessingServices;


    App(List<IPluginService> gamePluginServices,List<IProcessorService> entityProcessingServiceList,List<IPostProcessorService> postEntityProcessingServices) {
        this.gamePluginServices = gamePluginServices;
        this.entityProcessingServiceList = entityProcessingServiceList;
        this.postEntityProcessingServices = postEntityProcessingServices;
    }

    private final Pane gameWindow = new Pane();
    public static void main(String[] args) {
        System.out.println("Hello World");
        //launch(args);
    }

    public void start(Stage stage) throws Exception {


        GameData gameData = new GameData();
        World world = new World();
        gameData.initialize(stage);
        for (IPluginService service : gamePluginServices) {
            service.start(gameData,world);
            System.out.println("Plugin Service loaded");
        }

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (IProcessorService service : entityProcessingServiceList) {
                    service.process(gameData,world);

                }
                for (IPostProcessorService service : postEntityProcessingServices) {
                    service.process(gameData,world);
                }
                gameData.draw(world);

            }

        }.start();



    }





}