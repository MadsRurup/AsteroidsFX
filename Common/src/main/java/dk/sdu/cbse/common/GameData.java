package dk.sdu.cbse.common;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
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

    public Pane getGameWindow() {
        return this.gameWindow;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

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
        setHeight((int) gameWindow.getHeight());
        setWidth((int) gameWindow.getWidth());
        // For adding text to see the current input
        Text text = new Text();
        StringBuilder string = new StringBuilder();
        for (Integer val: gameInput.getPressed()) {
            string.append(gameInput.getKeyName(val)).append("(").append(val).append(")").append(", ");
        }
        text.setText(string.toString());
        text.setTranslateX(100);
        text.setTranslateY(100);
        gameWindow.getChildren().add(text);

        for (Entity entity: world.getEntities()) {
            Polygon polygon = new Polygon(entity.getPolygonCoordinates());
            Translate translate = new Translate(entity.getX(),entity.getY());
            //polygon.setTranslateX(entity.getX());
            //polygon.setTranslateY(entity.getY());
            //polygon.setRotate(entity.getRotation());
            polygon.getTransforms().add(translate);
            Rotate rotate = new Rotate(entity.getRotation(), 0, 0);
            polygon.getTransforms().add(rotate);
            polygon.setFill(Color.BLACK);
            gameWindow.getChildren().add(polygon);

            // Used to check polygon matches with coords
            Polygon polygon1 = new Polygon(1, -1, 1, 1, -1, 1, -1, -1);
            polygon1.setTranslateX(entity.getX());
            polygon1.setTranslateY(entity.getY());
            polygon1.setRotate(entity.getRotation());
            polygon1.setFill(Color.RED);
            gameWindow.getChildren().add(polygon1);
        }
    }

    public GameInput getGameInput() {
        return gameInput;
    }
}
