package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by admin on 07.02.2017.
 */
public class subjectsForObserver {
    private  ObservableList<subject> string = FXCollections.observableArrayList();
    private subject subject;
    public subjectsForObserver(){
        subject subj = new subject();

    }

    public sample.subject getSubject() {
        return subject;
    }

    public void setSubject(sample.subject subject) {
        this.subject = subject;
    }

    public ObservableList<subject> getString() {
        return string;
    }

    public void setString(ObservableList<subject> string) {

        this.string = string;
    }

    public ObservableList<subject> setItems() {
       loaderSabjects loaderSabjects = new loaderSabjects();
       loaderSabjects.setFileName("loaderSubject.doc");
       string.addAll(loaderSabjects.loadSubject());
        return string;
    }
}
