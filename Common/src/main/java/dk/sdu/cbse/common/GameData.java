package dk.sdu.cbse.common;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.channels.Pipe;
import java.util.Collection;

public class GameData {
    Pane gameWindow = new Pane();
    private GameInput gameInput = new GameInput();
    double[] test = {0,0,0,100,100,100,100,0};
    Polygon polygon = new Polygon(test);
    private int width = 1000;
    private int height = 800;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void initialize(Stage stage) {

        gameWindow.setPrefSize(width, height);

        polygon.setFill(Color.BLACK);
        polygon.setTranslateX(200);
        polygon.setRotate(30);
        gameWindow.getChildren().add(polygon);
        Scene scene = new Scene(gameWindow);

        scene.setOnKeyPressed(event -> {
            gameInput.setPressed(event.getCode().getCode(),true);
        });
        scene.setOnKeyReleased(event -> {
            gameInput.setPressed(event.getCode().getCode(),false);
        });

        stage.setScene(scene);
        stage.setTitle("AsteroidFX");
        stage.show();

        
    }
    public void draw(World world) {
        gameWindow.getChildren().clear();
        Text text = new Text();
        StringBuilder string = new StringBuilder();
        for (Integer val: gameInput.getPressed()) {
            string.append(gameInput.getKeyName(val)).append(", ");
        }
        text.setText(string.toString());
        text.setTranslateX(100);
        text.setTranslateY(100);
        gameWindow.getChildren().add(text);
        for (Entity entity: world.getEntities()) {
            Polygon polygon = new Polygon(entity.getPolygonCoordinates());
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());
            polygon.setFill(Color.BLACK);
            gameWindow.getChildren().add(polygon);
        }
    }

    public GameInput getGameInput() {
        return gameInput;
    }
}
