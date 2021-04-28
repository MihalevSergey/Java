package Lesson5.HW;

class CreateArr extends Thread{
    static final int size = 10000000;
    static final int h = size / 2;



    public void arrOneTime() {


        float[] arr = new float[size];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();

        long time = start - end;
        System.out.print("Without threads: ");
        System.out.println(System.currentTimeMillis() - time);


    }

    public void arrTwoTime() {


        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long start = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < a1.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t1.start();
        t2.start();


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long end = System.currentTimeMillis();

        long time = start - end;
        System.out.print("With threads: ");
        System.out.println(System.currentTimeMillis() - time);

    }
}

public class ThreadTest {
    public static void main(String[] args) {
        CreateArr ca = new CreateArr();

        ca.arrOneTime();
        ca.arrTwoTime();


    }

}
