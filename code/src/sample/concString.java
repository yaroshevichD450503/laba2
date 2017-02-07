package sample;

import com.sun.glass.ui.SystemClipboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import sample.subject;

/**
 * Created by admin on 07.02.2017.
 */
public class concString {

    public ArrayList<String> concatenation(ObservableList<subject> Data) {
        ArrayList<String> tempString = new ArrayList<String>();
        for(int i = 0; i < Data.size(); i++) {
          for(int j = 0; j < Data.get(i).getlaboratoryWork().size(); j++) {
              tempString.add(Data.get(i).getName()+" "+
                              Data.get(i).getlaboratoryWork().get(j).getDate()+" "+
                              Data.get(i).getlaboratoryWork().get(j).getMark()+" "+
                              Data.get(i).getlaboratoryWork().get(j).getId()+" "+
                              Data.get(i).getlaboratoryWork().get(j).getSchedule()+" "+
                              Data.get(i).getlaboratoryWork().get(j).getTask());
          }
        }
        return tempString;
    }
}


