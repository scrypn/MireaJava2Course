import java.util.ArrayList;
import java.util.Scanner;

public class Prac002 {
    public static void main(String[] args) {
        TestBall.test();
    }
}
/** 1 */
class Author{
    private final String name;
    private String email;
    private final char gender;
    Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public char getGender(){
        return this.gender;
    }
    @Override
    public String toString(){
        return String.format("Author{name: %s, email: %s, gender: %c}", name, email, gender);
    }
}
class TestAuthor {
    private static final Scanner sc = new Scanner(System.in);
    public static void test(){
        System.out.println("Enter name, email, gender(M, F):");
        Author author = new Author(sc.nextLine(), sc.nextLine(), sc.next().charAt(0));
        System.out.println("Select action: 1)get name, 2)get email, 3)set email, 4)get gender, 5)print data in one string");
        switch (sc.nextInt()){
            case 1:
                System.out.printf("Name: %s", author.getName());
                break;
            case 2:
                System.out.printf("Email: %s", author.getEmail());
                break;
            case 3:
                System.out.println("Enter new email:");
                author.setEmail(sc.nextLine());
                System.out.println("Email updated successfully");
                break;
            case 4:
                System.out.printf("Gender: %c", author.getGender());
                break;
            case 5:
                System.out.println(author);
                break;
            default:
                System.out.println("Command not found");
        }

    }
}
/** 2 */
class Ball{
    private double x, y = 0;
    Ball(){}
    Ball(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return this.y;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void move(double xDisp, double yDisp){
        x+=xDisp;
        y+=yDisp;
    }
    @Override
    public String toString(){
        return String.format("Ball{x: %.2f, y: %.2f}", x, y);
    }
}
class TestBall{
    private static final Scanner sc = new Scanner(System.in);
    public static void test(){
        System.out.println("Enter start coords:");
        Ball ball;
        try{
            ball = new Ball(sc.nextDouble(), sc.nextDouble());
        }catch (Exception e){
            ball = new Ball();
        }
        System.out.println("Select action: 1)get X, 2)set X, 3)get Y, 4)set Y, 5)set X and Y, 6)move ball, 7)print data in one string");
        switch (sc.nextInt()){
            case 1:
                System.out.printf("X coord: %.2f", ball.getX());
                break;
            case 2:
                System.out.println("Enter x coord:");
                ball.setX(sc.nextDouble());
                System.out.println("X coord updated successfully");
                break;
            case 3:
                System.out.printf("Y coord: %.2f", ball.getY());
                break;
            case 4:
                System.out.println("Enter y coord:");
                ball.setY(sc.nextDouble());
                System.out.println("Y coord updated successfully");
                break;
            case 5:
                System.out.println("Enter x and y coords:");
                ball.setXY(sc.nextDouble(), sc.nextDouble());
                System.out.println("X and Y coords updated successfully");
                break;
            case 6:
                System.out.println("Enter moving coords:");
                ball.move(sc.nextDouble(), sc.nextDouble());
                System.out.printf("Ball moved to coords (%f; %f)", ball.getX(), ball.getY());
                break;
            case 7:
                System.out.println(ball);
                break;
            default:
                System.out.println("Command not found");
        }
    }
}
/** 3 */
class Point{
    private float x,y = 0;
    Point(float x, float y){
        this.x = x;
        this.y = y;
    }

}
class Circle{
    Point center;
    ArrayList<Point> points = new ArrayList<>(16);
    Circle(float x, float y){
        center = new Point(x, y);
    }
    public void addPoint(float x, float y){
        points.add(new Point(x, y));
    }
}
class Tester{
    private static ArrayList<Circle> circles = new ArrayList<>(16);
    private static int size = 0;

    public static void test(){
        for (int i = 0; i < 10; i++) {
            circles.add(new Circle(34, 45));
            size++;
        }
    }
}
/** 4 */
/*class Shop{
    private ArrayList<>
}
interface Computer{
    int price;
}*/
