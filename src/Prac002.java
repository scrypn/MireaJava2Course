import java.util.Scanner;

public class Prac002 {
    public static void main(String[] args) {
        TestAuthor.test();
    }
}
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
