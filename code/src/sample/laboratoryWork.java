package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Iterator;
public class laboratoryWork {
    private final StringProperty id;
    private final StringProperty task;
    private final StringProperty date;
    private final StringProperty mark;
    private final StringProperty schedule;

    public laboratoryWork(){ this(null,null,null,null,null);

    }
    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param id
     * @param task
     * @param date
     * @param mark
     * @param schedule
     */
    public laboratoryWork(String id, String task, String date, String mark, String schedule) {
        this.id = new SimpleStringProperty(id);
        this.task = new SimpleStringProperty(task);
        this.date = new SimpleStringProperty(date);
        this.mark = new SimpleStringProperty(mark);
        this.schedule = new SimpleStringProperty(schedule);
    }
    public laboratoryWork(ArrayList<String> tempString) {
        ArrayList<String> tempS = tempString;
        Iterator it = tempS.iterator();
        if(tempS.size()>= 5){
            it.next();
       // for (Iterator it = tempS.iterator(); it.hasNext(); ){
       this.id =  new SimpleStringProperty((String)it.next());
      //  System.out.println((String)it.next());
        this.task = new SimpleStringProperty((String)it.next());
       // System.out.println((String)it.next());
        this.date = new SimpleStringProperty((String)it.next());
        //System.out.println((String)it.next());
        this.mark = new SimpleStringProperty((String)it.next());
//        System.out.println((String)it.next());
        this.schedule = new SimpleStringProperty((String)it.next());
        //System.out.println((String)it.next());
    }else{
            this.id = new SimpleStringProperty("sdfgv");
            this.task = new SimpleStringProperty("sdfgv");
            this.date = new SimpleStringProperty("sdfgv");
            this.mark = new SimpleStringProperty("sdfgv");
            this.schedule = new SimpleStringProperty("sdfgv");
    }}
    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getTask() {
        return task.get();
    }

    public StringProperty taskProperty() {
        return task;
    }

    public void setTask(String task) {
        this.task.set(task);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getMark() {
        return mark.get();
    }

    public StringProperty markProperty() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark.set(mark);
    }

    public String getSchedule() {
        return schedule.get();
    }

    public StringProperty scheduleProperty() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule.set(schedule);
    }
}
