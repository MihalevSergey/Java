package Lesson3.DopDZ;

import java.util.Scanner;
import java.util.regex.*;

public class ChekPassword {
    public boolean test(String password) {
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&($)+=]).{8,}$");


        Matcher m = p.matcher(password);
        return m.matches();
    }




    public static void main(String[] args) {
        ChekPassword cp = new ChekPassword();

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите пароль: ");

        String str = sc.next();


            System.out.println(cp.test(str));





    }
}
//(?=\S+$)