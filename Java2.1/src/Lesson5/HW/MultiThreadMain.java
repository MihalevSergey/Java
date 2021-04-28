package Lesson5.HW;

import java.util.Arrays;
import static java.lang.System.currentTimeMillis;
import static  java.lang.Math.cos;
import static  java.lang.Math.sin;


public class MultiThreadMain {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int THREADS_COUNT = 10;
        //определяется размер двумерного массива
        final int PART_SIZE = SIZE / THREADS_COUNT;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);
        long startTime = currentTimeMillis();
        //разделяем данные
        final float[][] a = new float[THREADS_COUNT][PART_SIZE];
        //создаем массив потоков
        Thread[] t = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            //будем копировать в двумерный массив данные из основного потока со сдвигом
            System.arraycopy(arr, PART_SIZE * i, a[i], 0, PART_SIZE);
            final int u = i;
            t[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    //считаем массив со сдвигом
                    int n = u * PART_SIZE;
                    for (int j = 0; j < PART_SIZE; j++, n++) {
                        a[u][j] = (float) (a[u][j] * sin(0.2f + n / 5) * cos(0.2f + n / 5) * cos(0.4f + n / 2));
                    }

                }
            });
            t[i].start();
        }
        try{
            for (int i = 0; i < THREADS_COUNT; i++) {
                t[i].join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //склеиваем массивы обратно в один
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(a[i], 0, arr, i * PART_SIZE, PART_SIZE);
        }
        // определяем время
        System.out.println(currentTimeMillis() - startTime);
    }
}
