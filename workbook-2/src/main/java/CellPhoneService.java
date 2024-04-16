import java.util.Scanner;

public class CellPhoneService {

    public static void main(String[] args) {
        CellPhone phone = new CellPhone();
        Scanner scanner = new Scanner(System.in);

        // Prompt for and update phone object info
        System.out.print("What is the serial number? ");
        phone.setSerialNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.print("What model is the phone? ");
        phone.setModel(scanner.nextLine());

        System.out.print("Who is the carrier? ");
        phone.setCarrier(scanner.nextLine());

        System.out.print("What is the phone number? ");
        phone.setPhoneNumber(scanner.nextLine());

        System.out.print("Who is the owner of the phone? ");
        phone.setOwner(scanner.nextLine());
        System.out.println(" ");

        // Print out the phone properties
        System.out.println("Cell Phone Properties:");
        System.out.println("Serial Number: "+phone.getSerialNumber());
        System.out.println("Model: "+phone.getModel());
        System.out.println("Carrier: "+phone.getCarrier());
        System.out.println("Phone Number: "+phone.getPhoneNumber());
        System.out.println("Owner: "+phone.getOwner());


    }

    public static class CellPhone {
        private int serialNumber;
        private String model;
        private String carrier;
        private String phoneNumber;
        private String owner;

        // Parameterless constructor
        public CellPhone(){
            this.serialNumber = 0;
            this.model = "";
            this.carrier = "";
            this.phoneNumber = "";
            this.owner = "";
        }

        // Getter and Setter methods for parameters
        // Getters
        public int getSerialNumber() {
            return this.serialNumber;
        }

        public String getModel() {
            return this.model;
        }

        public String getCarrier() {
            return this.carrier;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public String getOwner() {
            return this.owner;
        }

        // Setters
        public void setSerialNumber(int serialNumber){
            this.serialNumber = serialNumber;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setCarrier(String carrier){
            this.carrier = carrier;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}
