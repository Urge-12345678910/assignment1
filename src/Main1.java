import java.sql.SQLOutput;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args){
     /*
        System.out.println("i like chupa lagman");
        Scanner scanner= new Scanner(System.in);

        System.out.println("enter width:");
        double width = scanner.nextDouble();

        System.out.println("enter length cm ");
        double length = scanner.nextDouble();

        System.out.println(length * width);
        System.out.println(2 * (length + width));*/

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = scanner.nextLine();

        System.out.println("Введите число");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите профессию");
        String prof = scanner.nextLine();

        System.out.println("Человек по имени " + name + " которому " + age + " лет "  + " работает на профессию " + prof);

    }
}
