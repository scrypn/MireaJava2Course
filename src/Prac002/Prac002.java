package Prac002;

import java.util.*;


public class Prac002 {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Task 1
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
        public static void main(String[] args) {
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
     * Task 2
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
        public static void main(String[] args) {
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
     * Task 3
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

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                circles.add(new Circle(34, 45));
                size++;
            }
        }
    }

    /**
     * Task 4
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
        public static void main(String[] args) {
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

    /**
     * Task 5
     */
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
        public String toString() {
            return String.format("Dog{name: %s, age: %d}", name, age);
        }


    }

    static class PitomnikDog {
        private static ArrayList<Dog> dogs = new ArrayList<>(16);

        public static void main(String[] args) {
            addDogs();
        }

        public static void addDogs() {
            for (int i = 0; i < 16; i++) {
                //System.out.println("Enter dog's param:");
                dogs.add(new Dog("dogg", (int) ((Math.random() * 100) + 1)));
                //System.out.println("Dogs added successfully");
            }
            for (Dog d : dogs) {
                System.out.println(d.dogAgeToHuman());
            }
        }
    }

    /**
     * Task 6
     */
    static class ModelCircle {
        private int xCenter, yCenter = 0;
        private float radius;

        ModelCircle(float radius) {
            this.radius = radius;
        }

        ModelCircle(int xCenter, int yCenter, float radius) {
            this.xCenter = xCenter;
            this.yCenter = yCenter;
            this.radius = radius;
        }

        public int getXCenter() {
            return this.xCenter;
        }

        public void setXCenter(int xCenter) {
            this.xCenter = xCenter;
        }

        public int getYCenter() {
            return this.yCenter;
        }

        public void setYCenter(int yCenter) {
            this.yCenter = yCenter;
        }

        public float getRadius() {
            return this.radius;
        }

        public void setRadius(float radius) {
            this.radius = radius;
        }

        public float calcCircleArea() {
            return (float) (Math.PI * Math.pow(this.radius, 2));
        }

        public float calcCircleLength() {
            return (float) (2 * Math.PI * this.radius);
        }

    }

    static class TestCircle {
        public static void main(String[] args) {
            ModelCircle mc = new ModelCircle(12, 23, 56);
            mc.setXCenter(mc.getXCenter() + 5);
            mc.setYCenter(mc.getYCenter() + 6);
            mc.setRadius(mc.getRadius() - 4);
            System.out.printf("X: %d, Y: %d\nArea: %f, Length: %f", mc.getXCenter(), mc.getYCenter(), mc.calcCircleArea(), mc.calcCircleLength());
        }
    }

    /**
     * Task 7
     */
    static class Book {
        private String author, title, publishYear;

        Book(String author, String title, String publishYear) {
            this.author = author;
            this.title = title;
            this.publishYear = publishYear;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublishYear() {
            return this.publishYear;
        }

        public void setPublishYear(String publishYear) {
            this.publishYear = publishYear;
        }

        @Override
        public String toString() {
            return String.format("Book{author: %s,title: %s,publishYear: %s}", author, title, publishYear);
        }
    }

    static class Bookshelf {
        ArrayList<Book> books = new ArrayList<>(16);

        public void addBook(String author, String title, String publishYear) {
            books.add(new Book(author, title, publishYear));
        }

        public void sort() {
            books.sort((b1, b2) -> b1.getPublishYear().compareTo(b2.getPublishYear()));
        }

        public void printBooks() {
            for (Book b : books) {
                System.out.println(b);
            }
        }

        public void earlyBooks() {
            this.sort();
            for (Book b : books) {
                if (Objects.equals(books.get(0).publishYear, b.publishYear)) System.out.println(b);
            }
        }

        public void lastBooks() {
            this.sort();
            for (Book b : books) {
                if (Objects.equals(books.get(books.size() - 1).publishYear, b.publishYear)) System.out.println(b);
            }
        }
    }

    static class TestBook {
        public static void main(String[] args) {
            Bookshelf bs = new Bookshelf();
            for (int i = 0; i < 15; i++) {
                bs.addBook("Kolya", "Title" + (i + 1), String.valueOf((int) ((Math.random() * 40) + 1980)));
            }
            bs.printBooks();
            bs.sort();
            System.out.println("---------------------------------------");
            bs.earlyBooks();
            System.out.println("---------------------------------------");
            bs.lastBooks();
            System.out.println("---------------------------------------");
            bs.printBooks();

        }
    }

    /**
     * Task 8
     */
    static class arrayMoveItems {
        public static void main(String[] args) {
            String buff;
            String[] arr = new String[11];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = "item" + (i + 1);
            }
            for (String s : arr) {
                System.out.println(s);
            }
            System.out.println("------------------------------");
            for (int i = 0; i < (int) (arr.length / 2); i++) {
                buff = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = buff;
            }
            for (String s : arr) {
                System.out.println(s);
            }
        }
    }

    /**
     * Task 9
     */
    static class Poker {
        public static void main(String[] args) {
            String[] suits = new String[]{"diamond ", "club ", "heart ", "spade "};
            String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
            ArrayList<String> cards = new ArrayList<>(52);
            int n = 5;
            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(suit + rank);
                }
            }
            int index;
            for (int i = 0; i < n; i++) {
                System.out.printf("Player %d:\n", i+1);
                for (int j = 0; j < 5; j++) {
                    index = (int) (Math.random() * (cards.size() - 1));
                    System.out.println(cards.get(index));
                    cards.remove(index);
                }
            }
        }
    }

    /**
     * Task 10
     */
    static class HowMany{
        public static void main(String[] args) {
            String s = sc.nextLine();
            System.out.println(s.split(" ").length);
        }
    }
}
