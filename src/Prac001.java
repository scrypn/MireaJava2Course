import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prac001 {
    static void t3() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        float sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.printf("Sum is %f\nAvg is %f", sum, sum / 10);
    }

    static void t4() {
        Scanner sc = new Scanner(System.in);
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

    public static void main(String[] args) {
        t3();
    }
}
