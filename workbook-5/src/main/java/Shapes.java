import com.pluralsight.Box;
import com.pluralsight.Rectangle;
import com.pluralsight.Shape;
import com.pluralsight.Square;

import java.util.Scanner;

public class Shapes {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        System.out.println("""
                What shape would you like to display?
                1) Rectangle
                2) Box
                3) Square
                0) Exit""");
        int choice = scanner.nextInt();

        if (choice == 1){
            rectangle();
            menu();
        } else if (choice == 2) {
            box();
            menu();
        } else if (choice == 3) {
            square();
            menu();
        } else {
            System.exit(0);
        }

    }

    static void rectangle() {
        System.out.println("Rectangle");
        System.out.print("Enter the length : ");
        int length = scanner.nextInt();
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();

        Rectangle rectangle = new Rectangle(length,width);
        System.out.println("The area is : "+rectangle.getArea());
    }

    static void box() {
        System.out.println("Box");
        System.out.print("Enter the length : ");
        int length = scanner.nextInt();
        System.out.print("Enter the width : ");
        int width = scanner.nextInt();
        System.out.print("Enter height : ");
        int height = scanner.nextInt();

        Box box = new Box(length,width,height);
        System.out.println("The surface area is : "+box.getArea());
    }

    static void square() {
        System.out.println("Square");
        System.out.print("Enter the length : ");
        int length = scanner.nextInt();
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();

        Square square = new Square(length, width);
        if (square.getArea()==0){
            System.out.println("that is not a square");
        } else {
            System.out.println("The area is : "+square.getArea());
        }
    }
}
