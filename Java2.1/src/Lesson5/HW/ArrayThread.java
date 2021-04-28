package Lesson5.HW;

public class ArrayThread extends Thread {
    static final int size = 10000000;
    static final int h = size / 2;
    float arr[] = new float[size];
    long a = System.currentTimeMillis();
    float[] a1 = new float[h];
    float[] a2 = new float[h];


    public void setArr() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.out.println("Заполнение целого массива: " + (System.currentTimeMillis() - a));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Просчет целового массива: " + (System.currentTimeMillis() - a));
    }


    public void sepArray() {
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("Разделение массива: " + (System.currentTimeMillis() - a));

    }

    public void joinArray() {
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Склейка массивов: " + (System.currentTimeMillis() - a));
    }

    public void arrThread() throws InterruptedException {
        Thread t1 = new Thread(() -> {

                for (int i = 0; i < a1.length; i++) {
                    a1[i] = 1;

                }

                System.out.println("Заполнение первой половины массива: " + (System.currentTimeMillis() - a));

                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }
                System.out.println("Просчет первой половины массива: " + (System.currentTimeMillis() - a));

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = 1;

            }

            System.out.println("Заполнение второй половины массива: " + (System.currentTimeMillis() - a));

            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }

            System.out.println("Просчет второй половины массива: " + (System.currentTimeMillis() - a));

        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }



    }

    class Main {
        public static void main(String[] args) {
            ArrayThread at = new ArrayThread();
            at.setArr();
            try {
                at.sepArray();
                at.arrThread();
                at.joinArray();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }