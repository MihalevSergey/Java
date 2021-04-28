package Lesson3.HW.Phonebook;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Phonebook {
    Map<Integer, String> map = new HashMap<Integer, String>();


    public void setPhonebook(Map map) {
        this.map = map;
    }

    public void getPhonebook(String s) {
        int i = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(s.equals(entry.getValue())){
                i = entry.getKey();
               info(s, i);

            }

        }
        if(i == 0){
            s = "Такой фамилии нет";
            info(s,i);
        }


    }

    public void info(String s, int i){
        System.out.println("Номер телефона работника: " + s + " — " + i);
    }


    public static void main(String[] args) {
        Phonebook pb = new Phonebook();

        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1122, "Ivanov");
        map.put(2333, "Зуекщм");
        map.put(296559, "Sidorenkov");
        map.put(543513, "Khafizov");
        map.put(55566, "Ivanov");

        pb.setPhonebook(map);
        pb.getPhonebook("Ivanov");
        pb.getPhonebook("Khafizov");
        pb.getPhonebook("SynSukin");



    }


}

