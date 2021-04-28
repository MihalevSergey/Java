package Lesson3;

import java.io.*;

public class TestClass {
    public static void main(String[] args) {
         File file = new File("123");
         file.mkdir();
         String[] str = file.list();

         for (String s : str){
             System.out.println(s);
         }

    }


}
