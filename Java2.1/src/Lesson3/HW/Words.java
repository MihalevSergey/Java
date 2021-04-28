package Lesson3.HW;

import java.util.ArrayList;
import java.util.Iterator;

public class Words {



    public static ArrayList<String> arr(ArrayList<String> arrayList){

        Iterator<String> iter = arrayList.iterator();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add(arrayList.get(1));
        while (iter.hasNext()){
            String s = iter.next();

            if (!arrayList2.contains(s)){
                arrayList2.add(s);
            }

           // System.out.println(arrayList2);
        }


        return arrayList2;
    }

    public static void info(ArrayList<String> arr){
        System.out.println(arr);
    }




    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Барханный");
        al.add("Виверовый");
        al.add("Ягуарунди");
        al.add("Ягуарунди");
        al.add("Каракал");
        al.add("Камышовый");
        al.add("Лесной");
        al.add("Манул");
        al.add("Сфинкс");
        al.add("Манул");
        al.add("Сервал");



        info(arr(al));








    }

}
