package dk.sdu.cbse;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        App app = ctx.getBean(App.class);
        app.start(stage);
    }
}
