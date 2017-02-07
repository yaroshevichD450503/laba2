package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PersonAddDialogController {
    private Main mainApp;
    @FXML
    private TextField firstNameField;
    @FXML
    private TableView<subject> table;
    @FXML
    private TableColumn<subject, String> name;
    private Stage dialogStage;
    private subject subject;
    private boolean okClicked = false;
    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
       name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> show(newValue));
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     *
     * @param subjectsForObserver
     */
    public void setPerson(subjectsForObserver subjectsForObserver) {
        table.setItems(subjectsForObserver.getString());
    }

    /**
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
       //if (isInputValid()) {
            mainApp.getPersonData().add(this.subject);
            okClicked = true;
            dialogStage.close();
        //}
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {

            return true;
        }

    public void show(subject subject){
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        mainApp.getSubjectsForObserver().setSubject(subject);
        this.subject = subject;
        if (okClicked) {
            //mainApp.getPersonData().add(subject);
        }
    }
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

}
