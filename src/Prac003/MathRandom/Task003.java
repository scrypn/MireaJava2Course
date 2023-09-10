package Prac003.MathRandom;

import java.util.Random;

public class Task003 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 + r.nextInt(109);
            System.out.printf("%d ", arr[i]);
        }
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i]>=arr[i+1])isSorted = false;
        }
        System.out.println(isSorted ? "Отсортирован" : "Неотсортирован");
    }
}
