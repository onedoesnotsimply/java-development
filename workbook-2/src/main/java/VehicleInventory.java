import java.util.Scanner;

public class VehicleInventory {
    /*
    Manages the inventory of a used car dealership.
    Allows users to look up and add vehicles to a list.
     */

    // Initialize vehicle array and scanner object
    static Vehicle[] vehicleList = new Vehicle[20];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Populate with 6 vehicles
        vehicleList[0] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        vehicleList[1] = new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        vehicleList[2] = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        vehicleList[3] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        vehicleList[4] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        vehicleList[5] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);

        do {
            System.out.println(" ");
            System.out.println("What do you want to do?");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.println(" ");
            System.out.print("Enter your command: ");
            System.out.println(" ");

            // Get user command
            int command = scanner.nextInt();

            // Consume newline
            scanner.nextLine();

            switch (command) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    searchByModel();
                    break;
                case 3:
                    searchByPrice();
                    break;
                case 4:
                    searchByColor();
                    break;
                case 5:
                    addAVehicle(vehicleList);
                    break;
                case 6:
                    return;
            }
        } while(true);
    }

    // Lists all vehicles within the vehicles array
    public static void listAllVehicles() {
        for (Vehicle vehicle : vehicleList) {
            if (!(vehicle==null)){ // Only print the populated vehicle elements
                System.out.println(vehicle); // Prints the generated toString()
                System.out.println(" ");
            }
        }
    }

    // Search by make/model
    public static void searchByModel() {
        // Prompt for a search string
        System.out.print("Please enter the make/model: ");
        String make = scanner.nextLine();

        // For each vehicle in the vehicle array
        for (Vehicle vehicle : vehicleList) {
            if (!(vehicle == null)) {
                if (vehicle.getMakeModel().equalsIgnoreCase(make)) {
                    System.out.println(vehicle); // print it out
                }
            }
        }
    }

    // Search by price range
    public static void searchByPrice(){
        // Prompt for price range
        System.out.print("Please enter the minimum price: $");
        float minPrice = scanner.nextFloat();

        System.out.print("Please enter the maximum price: $");
        float maxPrice = scanner.nextFloat();

        // Find the vehicles within the price range
        for (Vehicle vehicle : vehicleList) {
            if(!(vehicle==null)){
                if (vehicle.getPrice()>=minPrice && vehicle.getPrice()<=maxPrice){
                    System.out.println(vehicle);
                }
            }
        }
    }

    // Search by color
    public static void searchByColor() {
        // Prompt for a search string
        System.out.print("Please enter the color of the vehicle: ");
        String color = scanner.nextLine();

        // For each vehicle in the vehicle array
        for (Vehicle vehicle : vehicleList) {
            if (!(vehicle == null)) {
                if (vehicle.getColor().equalsIgnoreCase(color)) {
                    System.out.println(vehicle); // print it out
                }
            }
        }
    }

    // Add a vehicle to the list
    public static void addAVehicle(Vehicle[] vehicleList) {
        //
        for (int i = 0; i < vehicleList.length; i++) {
            if (vehicleList[i]==null) {
                // Prompt for the object parameters
                System.out.println("Please fill out the following information");
                System.out.println(" ");

                System.out.print("Enter the vehicles make/model: ");
                String make = scanner.nextLine();

                System.out.print("Enter the color of the vehicle: ");
                String color = scanner.nextLine();

                System.out.print("Enter the odometer reading: ");
                int odometer = scanner.nextInt();

                System.out.print("Enter the price: $");
                float price = scanner.nextFloat();

                // Create new vehicle with the input
                Vehicle vehicle = new Vehicle(vehicleList[i-1].getVehicleId()+1, make,color,odometer,price);
                vehicleList[i] = vehicle;

                listAllVehicles();
                break;
            }
        }
    }


    // Vehicle class
    public static class Vehicle {
        // Initialize instance variables
        private long vehicleId;
        private String makeModel;
        private String color;
        private int odometerReading;
        private float price;

        // Constructor
        public Vehicle(long vehicleId,String makeModel,String color,int odometerReading,float price){
            this.vehicleId=vehicleId;
            this.makeModel=makeModel;
            this.color=color;
            this.odometerReading=odometerReading;
            this.price=price;
        }

        // To string method
        @Override
        public String toString() {
            return "Vehicle{" +
                    "vehicleId=" + vehicleId +
                    ", makeModel='" + makeModel + '\'' +
                    ", color='" + color + '\'' +
                    ", odometerReading=" + odometerReading +
                    ", price=" + price +
                    '}';
        }

        // Getter methods
        public long getVehicleId() {
            return vehicleId;
        }

        public String getMakeModel() {
            return makeModel;
        }

        public String getColor() {
            return color;
        }

        public int getOdometerReading() {
            return odometerReading;
        }

        public float getPrice() {
            return price;
        }

        // Setter methods
        public void setVehicleId(long vehicleId) {
            this.vehicleId = vehicleId;
        }

        public void setMakeModel(String makeModel) {
            this.makeModel = makeModel;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setOdometerReading(int odometerReading) {
            this.odometerReading = odometerReading;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }
}
