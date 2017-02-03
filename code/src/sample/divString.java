package sample;

import java.util.ArrayList;
import java.util.StringTokenizer;
import sample.fileWorker;
/**
 * Created by admin on 29.01.2017.
 */
public class divString {

    public static ArrayList<String> delimStroky(String string){
        String s = string;
        ArrayList<String> tempString = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            // System.out.println(st.nextToken());
            tempString.add(st.nextToken());

        }
        return tempString;
    }
   // public static void main(String[] args){

}//}
