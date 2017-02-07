package sample;

import javafx.collections.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Modality;
import java.io.IOException;
import sample.loaderSabjects;
public class Main extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;

    public sample.subjectsForObserver getSubjectsForObserver() {
        return subjectsForObserver;
    }

    private subjectsForObserver subjectsForObserver;
    private ObservableList<subject> Data = FXCollections.observableArrayList();
    //private client client;
    public Main() {
        subjectsForObserver = new subjectsForObserver();
        subjectsForObserver.setItems();
      Data.addAll( new loaderSabjects().loadSubject());
     // new loaderSabjects().saveSubject(Data);
    }
    public ObservableList<subject> getPersonData() {
        return Data;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("client");
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("sample.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            Controller controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean showPersonAddDialog(subjectsForObserver subjectsForObserver) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("PersonAddDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add subject");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PersonAddDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(subjectsForObserver);
            controller.setMainApp(this);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
