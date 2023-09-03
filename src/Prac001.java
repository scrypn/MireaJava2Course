import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prac001 {
    public static final Scanner sc = new Scanner(System.in);
    static void t3() {
        int[] arr = new int[10];
        float sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.printf("Sum is %.2f\nAvg is %.2f", sum, sum / 10);
    }

    static void t4() {
        ArrayList<Integer> arr = new ArrayList<>(16);

        int item;
        while (true) {
            try {
                item = sc.nextInt();
                if (item == 0) throw new Exception();
                arr.add(item);
            }catch (Exception e){
                break;
            }
        }
        if (!arr.isEmpty()) {
            Collections.sort(arr);

            int sum = 0;
            int i = 0;
            while (i < arr.size()) {
                sum += arr.get(i);
                i++;
            }
            System.out.printf("Summary Using While = %d\n", sum);
            sum = 0;
            i = 0;
            do {
                sum += arr.get(i);
                i++;
            } while (i < arr.size());
            System.out.printf("Summary Using Do-While = %d\nMin is %d, max is %d", sum, arr.get(0), arr.get(arr.size() - 1));
        }
    }

    static void t5(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
    static void t6(){
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%.2f\n", 1.0 / i);
        }
    }
    static int t7(){
        int value = sc.nextInt();
        if (value > 0) {
            int fact = 1;
            for (int i = 1; i <= value; i++) {
                fact *= i;
            }
            return fact;
        }
        return 0;
    }

    public static void main(String[] args) {
        t3();
        t4();
        t5(args);
        t6();
        System.out.printf("Factorial: %d", t7());
    }
}
