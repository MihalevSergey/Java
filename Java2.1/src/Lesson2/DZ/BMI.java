package Lesson2.DZ;


/*
        Необходимо рассчитать Индекс Массы Тела (Body Mass Index = BMI). Определяется она как вес делённый на рост в квадрате:

        BMI = вес / рост^2
        Здесь вес берется в килограммах, а рост в метрах.

        На основании этого показателя выделяют четыре категории:

        Underweight     -           BMI < 18.5      (недостаточная масса)
        Normal weight   -   18.5 <= BMI < 25.0      (норма)
        Overweight      -   25.0 <= BMI < 30.0      (избыточная масса)
        Obesity         -   30.0 <= BMI             (ожирение)
        Например, если я вешу 80 кг а мой рост 173 см то можно вычислить:

        BMI = 80 / (1.73)^2 = 26.7
        т.е. присутствует избыточный вес.

        вес в килограммах и рост в метрах.
        Ответ должен содержать одно из слов under, normal, over, obese, через пробел.
*/

import java.lang.reflect.Array;
import java.util.Arrays;


public class BMI {


    public static String[] indexBM(String s) {


        String[] splitN = s.split("\n");
        //System.out.println(splitN[1]);
        String[] index = new String[splitN.length];

        for (int i = 0; i < splitN.length; i++) {
            String[] mAndH = splitN[i].split(" ");
            Double[] d = new Double[2];
            //System.out.println(Arrays.toString(mAndH));
//            for (int j = 0; j < mAndH.length; j++) {
//                d[j] = (mAndH[j]);


            double bodyMassIndex = Double.parseDouble(mAndH[0]) / (Double.parseDouble(mAndH[1])
                    * Double.parseDouble(mAndH[1]));
            if (bodyMassIndex < 18.5) {
                index[i] = "UNDER";
            } else if (bodyMassIndex <= 18 / 5 && bodyMassIndex < 25.0) {

                index[i] = "NORMAL";
            } else if (bodyMassIndex <= 25.0 && bodyMassIndex < 30.0) {
                index[i] = "OVER";
            } else {
                index[i] = "OBESE";
            }
            //index[i] = String.valueOf(bodyMassIndex);
            //System.out.println(mAndH);
        }
        return index;
    }




    public static void info(String[] d) {
        for (String o : d) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {

        String s = "118 2.05\n" +
                "06 1.77\n" +
                "87 1.83\n" +
                "45 1.12\n" +
                "70 1.87\n" +
                "54 1.57\n" +
                "105 1.76\n" +
                "50 1.96\n" +
                "114 1.76\n" +
                "72 2.45\n" +
                "53 2.10\n" +
                "66 2.25\n" +
                "54 1.50\n" +
                "95 1.62\n" +
                "86 1.72\n" +
                "62 1.57\n" +
                "65 2.24\n" +
                "72 1.43\n" +
                "93 2.01\n" +
                "109 3.01\n" +
                "106 2.97\n" +
                "77 1.69\n" +
                "114 2.09\n" +
                "98 1.72\n" +
                "85 2.46\n" +
                "113 1.94\n" +
                "53 1.77\n" +
                "106 2.30\n";


        info(indexBM(s));


    }
}




