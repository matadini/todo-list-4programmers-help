package sample;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Kontroler do glownej aplikacji
 */
public class Controller {

   // private ObservableList<TaskDescription> list= FXCollections.observableArrayList();

    @FXML
    private  ListView<TaskDescription> toDo=new ListView<>();

    @FXML
    private ListView<TaskDescription> inProgress;

    @FXML
    private ListView<TaskDescription> doneTasks;

    @FXML
    private Button addTask;

    private final EventBus eventBus;

    public Controller(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @FXML
    private void initialize() {
        addTask.setOnAction(this::addNewTask);
    }

    private void addNewTask(ActionEvent event)  {


        try {
            /*
             * Utworz zestaw: scena + controller
             */
            NewTaskController controller = new NewTaskController(eventBus);
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("NewTask.fxml"));
            loader.setController(controller);
            Scene value = new Scene(loader.load());

            /*
             * Stage
             */
            Stage stage = new Stage();
            stage.setScene(value);
            stage.showAndWait(); // showAndWait bo okno ma byc modal najpewniej

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void addToList(TaskDescription tmp)
    {
        /*
         * Miedzy widokiem a lista jest binding wiec wystarczy
         * do listy modelowej kontrolki wrzucic nowy element
         */
        toDo.getItems().add(tmp);
    }
}
