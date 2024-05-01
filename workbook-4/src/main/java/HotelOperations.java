public class HotelOperations {

    public static void main(String[] args) {
        // Initialize Room objects
        Room room1 = new Room(2, 350.99, true, true);
        Room room2 = new Room(1, 230.57, false, false);
        Room room3 = new Room(3, 500.00, false, true);
        // Print Room object information
        printRoomInfo(room1);
        printRoomInfo(room2);
        printRoomInfo(room3);

        System.out.println(" ");
        System.out.println(" ");

        // Initialize Reservation Objects
        Reservation reservation1 = new Reservation("King",2, true);
        Reservation reservation2 = new Reservation("double", 4, false);

        printReservationInfo(reservation1);
        printReservationInfo(reservation2);

        System.out.println(" ");
        System.out.println(" ");

        Employee employee1 = new Employee(1,"Ryan","Room Service",12.50, 45);

        printEmployeeInfo(employee1);
    }

    public static void printEmployeeInfo(Employee employee) {
        System.out.println("Employee ID "+employee.getEmployeeId()+"\n"+
                "Name "+employee.getName()+"\n"+
                "Department "+employee.getDepartment()+"\n"+
                "Pay Rate "+employee.getPayRate()+"\n"+
                "Hours Worked "+(employee.getRegularHours()+employee.getOvertimeHours())+"\n"+
                "Total Pay "+employee.getTotalPay());
    }

    public static void printReservationInfo(Reservation reservation){
        System.out.println("Room type "+reservation.getRoomType()+"\n"+
                "Length of stay "+ reservation.getNumberOfNights()+"\n"+
                "Nightly cost "+ reservation.getPrice()+"\n"+
                "Weekend stay "+ reservation.isWeekend()+"\n"+
                "Reservation total "+reservation.getReservationTotal());
    }

    public static void printRoomInfo(Room room) {
        System.out.println("Price " + room.getPrice() + "\n" +
                "Beds " + room.getNumberOfBeds() + "\n" +
                "Is occupied " + room.isOccupied() + "\n" +
                "Is Dirty " + room.isDirty() + "\n" +
                "Is Available " + room.isAvailable());
    }

    public static class Room {
        private int numberOfBeds;
        private double price;
        private boolean occupied;
        private boolean dirty;

        public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
            this.numberOfBeds = numberOfBeds;
            this.price = price;
            this.occupied = occupied;
            this.dirty = dirty;
        }

        public int getNumberOfBeds() {
            return numberOfBeds;
        }

        public double getPrice() {
            return price;
        }

        public boolean isOccupied() {
            return occupied;
        }

        public boolean isDirty() {
            return dirty;
        }

        public boolean isAvailable() {
            if ((!occupied) && (!dirty)) {
                return true;
            }
            return false;
        }
    }

    public static class Reservation {
        private String roomType;
        private int numberOfNights;
        private boolean isWeekend;

        public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
            this.roomType = roomType;
            this.numberOfNights = numberOfNights;
            this.isWeekend = isWeekend;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public int getNumberOfNights() {
            return numberOfNights;
        }

        public void setNumberOfNights(int numberOfNights) {
            this.numberOfNights = numberOfNights;
        }

        public boolean isWeekend() {
            return isWeekend;
        }

        public void setWeekend(boolean weekend) {
            isWeekend = weekend;
        }

        public double getPrice() {
            // If the roomType value is king
            if (roomType.equalsIgnoreCase("king")) {
                if (isWeekend) { // If it's a weekend
                    // The daily cost of the room goes up by 10%
                    return 139+(139*0.1);
                }
                // Return the weekday price of a king room
                return 139;
            }
            // There are only two options for roomType, so we don't need a second if for double
            if (isWeekend){
                // Calculate the weekend price
                return 124+(124*0.1);
            }
            return 124;
        }

        public double getReservationTotal() {
            // Calculate the total by getting the room price and multiplying it by the number of nights
            return (getPrice() * numberOfNights);
        }
    }

    public static class Employee {
        private int employeeId;
        private String name;
        private String department;
        private double payRate;
        private double hoursWorked;

        public Employee(int employeeId, String name, String department, double payRate, double hoursWorked){
            this.employeeId=employeeId;
            this.name=name;
            this.department=department;
            this.payRate=payRate;
            this.hoursWorked=hoursWorked;

        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public double getPayRate() {
            return payRate;
        }

        public String getDepartment() {
            return department;
        }

        public double getRegularHours() {
            if (hoursWorked>40){
                return 40;
            }
            return hoursWorked;
        }

        public double getOvertimeHours() {
            if (hoursWorked>40) {
                return hoursWorked-40;
            }
            return 0;
        }

        public double getTotalPay() {
            double totalPay;
            if (getOvertimeHours()>0) {
                return (payRate * getRegularHours())+(((payRate*1.5))*getOvertimeHours());
            }
            return payRate*getRegularHours();
        }
    }
}