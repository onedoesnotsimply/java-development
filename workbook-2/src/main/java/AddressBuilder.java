import java.util.Arrays;
import java.util.Scanner;

public class AddressBuilder {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Prompt for information
        System.out.println("Please provide the following information:");
        // Name
        System.out.print("Full name: ");
        String name = scanner.nextLine();

        // Call StringBuilder methods
        String billing = billingAddress();
        System.out.println(" ");
        String shipping = shippingAddress();
        System.out.println(" ");
        
        // Output information
        System.out.println(name);
        System.out.println(" ");
        System.out.println("Billing address: ");
        System.out.println(billing);
        System.out.println("Shipping address: ");
        System.out.println(shipping);

    }

    static String billingAddress() {
        StringBuilder addressBuilder = new StringBuilder();
        // Prompt for
        // Street
        System.out.println(" ");
        System.out.print("Billing Street: ");
        addressBuilder.append(scanner.nextLine().trim()).append("\n");
        // City
        System.out.print("Billing City: ");
        addressBuilder.append(scanner.nextLine().trim()).append(", ");
        // State
        System.out.print("Billing State: ");
        addressBuilder.append(scanner.nextLine().trim()).append(" ");
        // Zip
        System.out.print("Billing Zip: ");
        addressBuilder.append(scanner.nextLine().trim());

        return addressBuilder.toString();
    }

    static String shippingAddress(){
        StringBuilder addressBuilder = new StringBuilder();
        // Prompt for
        // Street
        System.out.println(" ");
        System.out.print("Shipping Street: ");
        addressBuilder.append(scanner.nextLine().trim()).append("\n");
        // City
        System.out.print("Shipping City: ");
        addressBuilder.append(scanner.nextLine().trim()).append(", ");
        // State
        System.out.print("Shipping State: ");
        addressBuilder.append(scanner.nextLine().trim()).append(" ");
        // Zip
        System.out.print("Shipping Zip: ");
        addressBuilder.append(scanner.nextLine().trim());

        return addressBuilder.toString();
    }

}
