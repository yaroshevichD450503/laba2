package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.divString;

public class loaderSabjects {


    private String fileName = "fileName.doc";
    ObservableList<subject> Data = FXCollections.observableArrayList();

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ObservableList<subject> loadSubject() {
        String fileName = this.fileName;
        divString divString = new divString();
        fileWorker fileWorker = new fileWorker();
        String temp = new String("start");
        subject subject = new subject(temp);

        //ObservableList<subject> Data = FXCollections.observableArrayList();
        ArrayList<String> tempString = fileWorker.readLine(fileName);
        System.out.println(tempString.size());

        for (String dataStr: tempString)  {
            System.out.println(dataStr);
           ArrayList<String> tempS = divString.delimStroky(dataStr);
            System.out.println(subject.getName().equals(tempS.get(0)));
            System.out.println(tempS.get(0) + "1");
            System.out.println(subject.getName() + "1");
         if(subject.getName().equals(tempS.get(0))) {
             System.out.println(tempS.size());
             subject.addLaboratoryWork(new laboratoryWork(tempS));
         }else {
             if(subject.getName().equals("start")){
                // System.out.println(subject.getName().equals("start"));
                 subject = new subject(tempS.get(0));
                 System.out.println(subject.getName());
                 subject.addLaboratoryWork(new laboratoryWork(tempS));
             }else{
                 System.out.println("2");
                 this.Data.add(subject);
                 subject = new subject(tempS.get(0));
                 subject.addLaboratoryWork(new laboratoryWork(tempS));
             }
         }

       }
           // System.out.println("Item:" + s);
        this.Data.add(subject);

            return Data;

    }


    public void saveSubject(ObservableList<subject> Data) {
        String fileName = this.fileName;
      //  divString divString = new divString();
        fileWorker fileWorker = new fileWorker();
        String temp = new String("start");
        subject subject = new subject(temp);

        ObservableList<subject> tempData = FXCollections.observableArrayList();
        tempData.addAll(Data);
        ArrayList<String> tempString = new concString().concatenation(tempData);
        String string = new String();
        for(int i = 0; i < tempString.size(); i++) {
            string = string + tempString.get(i)+"\n";
            fileWorker.write(fileName, string);
            System.out.println(tempString.get(i));
        }

    }
    public subject updateSubject(String nameSubject ) {
        String fileName = this.fileName;
        divString divString = new divString();
        fileWorker fileWorker = new fileWorker();
        String temp = new String("start");
        subject subj = new subject(nameSubject);

        //ObservableList<subject> Data = FXCollections.observableArrayList();
        ArrayList<String> tempString = fileWorker.readLine(fileName);
        System.out.println(tempString.size());
        for (String dataStr : tempString) {
            System.out.println(dataStr);
            ArrayList<String> tempS = divString.delimStroky(dataStr);
            if (subj.getName().equals(tempS.get(0))) {
                System.out.println(tempS.size());
                subj.addLaboratoryWork(new laboratoryWork(tempS));

            } else {
                System.out.println("2");
            }


        }
        // System.out.println("Item:" + s);
        return subj;
    }
 }
