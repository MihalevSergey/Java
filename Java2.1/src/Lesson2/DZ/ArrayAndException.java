package Lesson2.DZ;


import java.util.Arrays;

class MyArraySizeExeption extends Exception {
    public MyArraySizeExeption(String msg) {
        super(msg);
    }

}

class MyArrayDataExeption extends Exception {
    public MyArrayDataExeption(String msg) {
        super(msg);
    }
}


class ArraySize {
    int i;
    int j;
    String[][] array;

    public ArraySize(String[][] array) throws MyArraySizeExeption {
        this.array = array;
//        this.i = i;
//        this.j = j;

        if (array.length > 4) {
            throw new MyArraySizeExeption("размер массива не может быть больше 4х");
        }
        this.array = new String[i][j];

    }

}

class Array {
    String[][] array;
//    int i;
//    int j;
    int[][] arrayInt = new int[4][4];
    int ie;
    int je;

    public Array(String[][] array) throws MyArrayDataExeption {
        this.array = array;
//        this.i = i;
//        this.j = j;

//        for (int i = 0; i < array.length; i++) {
//
//            System.out.println(Arrays.toString(array[i]));
//        }
    }

    public int[][] parser() throws MyArrayDataExeption {
        try {
            for (int i = 0; i < array.length; i++) {
                ie = i;
//                arrayInt[k] = Integer.parseInt(array[k]);
              for (int j = 0; j < array.length; j++) {
                    je = j;
                    String s = array[i][j];
                  //System.out.println(s);
                    arrayInt[i][j] = Integer.parseInt(s);

                }
            }


        } catch (NumberFormatException e) {

            throw new MyArrayDataExeption("неверный формат данных в ячейке: " + ie + " " + je);
        }
        return arrayInt;

    }

    public void info(int[][] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(arrays[i]));
//            for (int j = 0; j < arrays.length; j++) {
//                System.out.print(arrays[j]);
//            }
        }
        System.out.println();


    }
    
    public int arraySum(int[][] arr){
        int sum = 0;
        for (int[] subArr : arr) {
            for(int subSubArr : subArr){
                sum += subSubArr;
            }
            
        }
        return sum;
    }

    public void info1(String[][] array) {
        this.array = array;

        for (int i = 0; i < array.length; i++) {

            System.out.println(Arrays.toString(array[i]));
        }

        


    }
}


public class ArrayAndException {
    public static void main(String[] args) throws MyArraySizeExeption, MyArrayDataExeption {
        String[][] test;

        test = new String[][]{
                {"0", "1", "2", "3" },
                {"4", "5", "6", "5"},
                {"8", "9", "10", "11"},
                {"12", "13", "14", "15"},
                {"1"}
        };

        ArraySize arrSize = new ArraySize(test);
        Array arr = new Array(test);

        arr.parser();
                arr.info(arr.parser());
        arr.info1(test);
        System.out.println(arr.arraySum(arr.parser()));

    }
}
