package dk.sdu.cbse;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class App extends Application {

    private final Pane gameWindow = new Pane();
    public static void main(String[] args) {
        System.out.println("Hello World");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane gameWindow = new Pane();
        double[] test = {0,0,0,100,100,100,100,0};
        Polygon polygon = new Polygon(test);

        gameWindow.setPrefSize(1000, 800);

        polygon.setFill(Color.BLACK);
        polygon.setTranslateX(200);
        polygon.setRotate(30);
        gameWindow.getChildren().add(polygon);
        Scene scene = new Scene(gameWindow);
        stage.setScene(scene);
        stage.setTitle("AsteroidFX");
        stage.show();

        GameData gameData = new GameData();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        polygon.setTranslateX(polygon.getTranslateX()+1);
                    }
                });

                gameData.draw();
            }

        }.start();
        World world = new World();
        gameData.initialize(stage);

    }


}