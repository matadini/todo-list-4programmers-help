package sample;

import com.google.common.eventbus.EventBus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    /*
     * Glowna szyna zdarzen w aplikacji
     */
    private final EventBus eventBus = new EventBus();


    @Override
    public void start(Stage primaryStage) throws Exception{

        /*
         * Controler + scena
         */
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("Controller.fxml"));
        Controller controller = new Controller(eventBus);
        eventBus.register(controller); // zarejestruj kontroler glownego widoku by mogl odbierac zdarzenia
        loader.setController(controller);
        Scene value = new Scene(loader.load());

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(value);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
