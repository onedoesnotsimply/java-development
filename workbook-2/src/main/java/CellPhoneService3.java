import java.util.Scanner;

public class CellPhoneService3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CellPhone phone1 = new CellPhone();
        CellPhone phone2 = new CellPhone();

        CellPhone phone3 = new CellPhone(2597153, "iPhone 15 Pro Max",
                "Verizon", "888-555-1234", "Sandra");

        // Prompt users for information on their phones
        promptInfo(phone1);
        promptInfo(phone2);

        // Display the phone properties
        display(phone1);
        display(phone2);

        // Dial other phone
        String number = phone2.getPhoneNumber();
        phone1.dial(number);
        phone2.dial(phone1.getPhoneNumber());
        phone3.dial(phone1);

    }

    // Populates CellPhone objects
    public static void promptInfo(CellPhone phone) {
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
    }

    // Displays CellPhone values
    public static void display(CellPhone phone) {
        System.out.println("Cell Phone Properties");
        System.out.println("Serial Number: "+phone.getSerialNumber());
        System.out.println("Model: "+phone.getModel());
        System.out.println("Carrier: "+phone.getCarrier());
        System.out.println("Phone Number: "+phone.getPhoneNumber());
        System.out.println("Owner: "+phone.getOwner());
        System.out.println(" ");
    }

    // CellPhone Class
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

        public CellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner){
            this.serialNumber = serialNumber;
            this.model = model;
            this.carrier = carrier;
            this.phoneNumber = phoneNumber;
            this.owner = owner;
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

        // Methods
        // Dials a phone number
        public void dial(String phoneNumber){
            System.out.printf("%s's phone is calling %s",this.owner, phoneNumber);
            System.out.println(" ");
        }

        // Overloaded dial method?
        public void dial(CellPhone cellPhone){
            System.out.printf("%s's phone is calling %s",this.owner, cellPhone.getPhoneNumber());
            System.out.println(" ");
        }
    }
}