package sample;


import com.google.common.eventbus.EventBus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NewTaskController {

    @FXML
    private TextField taskTitle;

    @FXML
    private ComboBox<String> choosePriority;

    @FXML
    private String lowTask;

    @FXML
    private String highTask;

    @FXML
    private DatePicker chooseDate;

    @FXML
    private TextArea textArea;

    @FXML
    private Button addTaskButton;

    private final EventBus eventBus;

    /**
     * Zaleznosci zewnetrzne wrzucamy przez konstruktor
     *
     * @param eventBus szyna zdarzen na ktorej naslucuje glowny kontroler
     */
    NewTaskController(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @FXML
    void initialize() {
        addTaskButton.setOnAction(this::addTask);
    }

    private void addTask(ActionEvent event) {

        /*
         * Na podstawie danych utworz nowy obiekt TaskDescription
         */
        TaskDescription tmp = new TaskDescription(taskTitle.getText(), choosePriority.getValue(), chooseDate.getValue(), textArea.getText());
        System.out.println(tmp);

        /*
         * Dodaj nowoutworzony element do glownego okna aplikacji
         * wyslij obiekt TaskDescription na magistrale zdarzen
         */
        eventBus.post(tmp);
    }

}
