package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import sample.Main;
import sample.subject;
public class Controller {
    @FXML
    private TableView<subject> personTable;
    @FXML
    private TableView<laboratoryWork> viewTable;
    @FXML
    private TableColumn<subject, String> firstNameColumn;
    @FXML
    private TableColumn<laboratoryWork, String> idColumn;
    @FXML
    private TableColumn<laboratoryWork, String> taskColumn;
    @FXML
    private TableColumn<laboratoryWork, String> dataColumn;
    @FXML
    private TableColumn<laboratoryWork, String> markColumn;
    @FXML
    private TableColumn<laboratoryWork, String> scheduleColumn;




    private Main mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public Controller() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        taskColumn.setCellValueFactory(cellData -> cellData.getValue().taskProperty());
        dataColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        markColumn.setCellValueFactory(cellData -> cellData.getValue().markProperty());
        scheduleColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleProperty());
       //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        personTable.setItems(mainApp.getPersonData());
    }
    private void showDetails(subject subject) {
        if (subject != null) {
            viewTable.setItems(subject.getlaboratoryWork());
        } else {
            // Если Person = null, то убираем весь текст.


        }
    }
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    @FXML
    private void handleNewPerson() {
        subject tempPerson = new subject();

        boolean okClicked = mainApp.showPersonAddDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопка Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */
    @FXML
    private void handleEditPerson() {
        subject selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonAddDialog(selectedPerson);
            if (okClicked) {
                showDetails(selectedPerson);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}
