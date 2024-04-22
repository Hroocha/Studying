package tasks.lesson6;

import java.util.Arrays;

public class Thread {

    static final int size = 10000000;
    static final int half = size / 2;

    private static void count(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }
    private static void count2(float[] arr) {
        for (int i = 0, j = half; i < arr.length; i++, j++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                    Math.cos(0.4f + j / 2));
        }
    }

    public void counter1() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        count(arr);
        System.out.println("time for counter1: " + (System.currentTimeMillis() - a));
    }

    public void counter2() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        //разбив
        long time = System.currentTimeMillis();
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        System.arraycopy(arr, 0, arr1, 0, half / 2);
        System.arraycopy(arr, half / 2, arr2, 0, half / 2);

        java.lang.Thread thread1 = new java.lang.Thread(() -> {
            count(arr1);
        });

        java.lang.Thread thread2 = new java.lang.Thread(() -> {
            count2(arr2);
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //склейка
        System.arraycopy(arr1, 0, arr, 0, half / 2);
        System.arraycopy(arr2, 0, arr, half / 2, half / 2);

        System.out.println("total time for counter2: " + (System.currentTimeMillis() - time));

    }


}
