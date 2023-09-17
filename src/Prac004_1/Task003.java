package Prac004_1;

public class Task003 {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("dsfsdf", 23);
    }
}
class Person{
    private String fullname;
    private int age;
    Person(){

    }
    Person(String fullname, int age){

    }
    public void move(){

    }
    public void talk(){
        System.out.println("Person talking");
    }

}
