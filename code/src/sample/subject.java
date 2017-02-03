package sample;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class subject {
    private final StringProperty name;
    public ObservableList<laboratoryWork> Date = FXCollections.observableArrayList();


    /**
     * Конструктор по умолчанию.
     */
    public subject() {
        this("123");
    }

    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param name
     */
    public subject(String name) {
        this.name = new SimpleStringProperty(name);
    }
    public subject(ArrayList<String> tempString) {
        Iterator it = tempString.iterator();
        this.name = new SimpleStringProperty((String)it.next());
        this.addLaboratoryWork(new laboratoryWork(tempString));

    }
    public void addLaboratoryWork (laboratoryWork Date){
        this.Date.add(Date);
    }
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }
    public ObservableList<laboratoryWork> getlaboratoryWork() {
        return Date;
    }
    public void setName(String name) {
        this.name.set(name);
    }

}
