package Prac003.MathRandom;

import java.util.Random;

public class Task001 {
    public static void main(String[] args) {
        float[] arr = new float[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 + (r.nextFloat() * 990);
            //arr[i] = (float)(10 + (Math.random() * 990));
            //System.out.println(arr[i]);
        }
        float buff;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    buff = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buff;
                }
            }
        }
        for (float f:arr) {
            System.out.println(f);
        }
    }
}
