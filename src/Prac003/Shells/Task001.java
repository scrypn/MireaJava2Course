package Prac003.Shells;

public class Task001 {
    public static void main(String[] args) {
        double a = Double.parseDouble("34344.34");
        Double obj = Double.parseDouble("3.1313");
        Double obj1 = Double.valueOf(3.1313);
        int c = obj.intValue();
        short sh = obj.shortValue();
        float f = obj.floatValue();
        String s = obj.toString();
        byte b = obj.byteValue();
        long l = obj.longValue();
        System.out.println(obj1);
        String d = Double.toString(3.14);

    }
}
