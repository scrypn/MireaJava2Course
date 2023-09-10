package Prac003.MathRandom;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n = 0;
        while(n<1) {
            n = sc.nextInt();
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(n);
            System.out.println(arr[i]);
        }
        ArrayList<Integer> arr2 = new ArrayList<>(16);
        for (int j : arr) {
            if (j % 2 == 0) arr2.add(j);
            System.out.println(j);
        }
    }
}
