import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Prac002 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PitomnikDog.addDogs();
    }

    /**
     * 1
     */
    static class Author {
        private final String name;
        private String email;
        private final char gender;

        Author(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        public String getName() {
            return this.name;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public char getGender() {
            return this.gender;
        }

        @Override
        public String toString() {
            return String.format("Author{name: %s, email: %s, gender: %c}", name, email, gender);
        }
    }

    static class TestAuthor {
        public static void test() {
            System.out.println("Enter name, email, gender(M, F):");
            Author author = new Author(sc.nextLine(), sc.nextLine(), sc.next().charAt(0));
            System.out.println("Select action: 1)get name, 2)get email, 3)set email, 4)get gender, 5)print data in one string");
            switch (sc.nextInt()) {
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

    /**
     * 2
     */
    static class Ball {
        private double x, y = 0;

        Ball() {
        }

        Ball(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return this.x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return this.y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void setXY(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void move(double xDisp, double yDisp) {
            x += xDisp;
            y += yDisp;
        }

        @Override
        public String toString() {
            return String.format("Ball{x: %.2f, y: %.2f}", x, y);
        }
    }

    static class TestBall {
        public static void test() {
            System.out.println("Enter start coords:");
            Ball ball;
            try {
                ball = new Ball(sc.nextDouble(), sc.nextDouble());
            } catch (Exception e) {
                ball = new Ball();
            }
            System.out.println("Select action: 1)get X, 2)set X, 3)get Y, 4)set Y, 5)set X and Y, 6)move ball, 7)print data in one string");
            switch (sc.nextInt()) {
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

    /**
     * 3
     */
    static class Point {
        private float x, y = 0;

        Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

    }

    static class Circle {
        Point center;
        ArrayList<Point> points = new ArrayList<>(16);

        Circle(float x, float y) {
            center = new Point(x, y);
        }

        public void addPoint(float x, float y) {
            points.add(new Point(x, y));
        }
    }

    static class Tester {
        private static ArrayList<Circle> circles = new ArrayList<>(16);
        private static int size = 0;

        public static void test() {
            for (int i = 0; i < 10; i++) {
                circles.add(new Circle(34, 45));
                size++;
            }
        }
    }

    /**
     * 4
     */
    static class Shop implements ComputerAdd {
        private ArrayList<Computer> comps = new ArrayList<>(16);

        @Override
        public void initComp() {
            while (true) {
                System.out.println("Enter computer price, inch and brand:");
                try {
                    comps.add(new Computer(sc.nextInt(), sc.nextFloat(), sc.next()));
                } catch (Exception e) {
                    break;
                }
            }
        }

        @Override
        public void addComp(Computer c) {
            //System.out.println("Enter computer price, inch and brand:");
            comps.add(c);
        }

        @Override
        public void removeComp(int index) {
            //System.out.println("Enter index of removing element:");
            //int index = sc.nextInt();
            if (index >= 0 && index < comps.size()) {
                comps.remove(index);
                System.out.println("Element deleted");
            }
        }

        @Override
        public void searchComp(Computer c) {
            //System.out.println("Enter comp configurations:");
            //Computer c = new Computer(sc.nextInt(), sc.nextFloat(), sc.nextLine());
            for (int i = 0; i < comps.size(); i++) {
                if (c.equals(comps.get(i))) {
                    System.out.printf("We have found the computer at %d position", i);
                }
            }

        }

        @Override
        public void printComps() {
            for (Computer c : comps) {
                System.out.println(c);
            }
        }
    }

    static class Computer {
        private int price;
        private float inch;
        private String brand;

        Computer(int price, float inch, String brand) {
            this.price = price;
            this.inch = inch;
            this.brand = brand;
        }

        @Override
        public boolean equals(Object obj) {
            Computer c = (Computer) obj;
            return (this.price == c.price && this.inch == c.inch && this.brand.equals(c.brand));
        }

        @Override
        public String toString() {
            return String.format("Computer{price: %d, inch: %f, brand: %s}", price, inch, brand);
        }
    }

    interface ComputerAdd {
        public void initComp();

        public void addComp(Computer c);

        public void removeComp(int index);

        public void searchComp(Computer c);

        public void printComps();
    }

    static class TestShop {
        public static void test() {
            Shop shop = new Shop();
            //shop.initComp();
            for (int i = 0; i < 10; i++) {
                shop.addComp(new Computer(1212 * (i + 1), i + 1, "apple"));
            }
            shop.printComps();
            shop.removeComp(1);
            shop.searchComp(new Computer(1212, 1, "apple"));
            shop.printComps();

        }
    }

    static class Dog {
        private String name;
        private int age;

        Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int dogAgeToHuman() {
            return age * 7;
        }
        @Override
        public String toString(){
            return String.format("Dog{name: %s, age: %d}", name, age);
        }


    }
    static class PitomnikDog{
        private static ArrayList<Dog> dogs = new ArrayList<>(16);
        public static void addDogs(){
            for (int i = 0; i < 16; i++) {
                //System.out.println("Enter dog's param:");
                dogs.add(new Dog("dogg", (int)((Math.random()*100)+1) ));
                //System.out.println("Dogs added successfully");
            }
            for (Dog d: dogs) {
                System.out.println(d.dogAgeToHuman());
            }
        }
    }
}
