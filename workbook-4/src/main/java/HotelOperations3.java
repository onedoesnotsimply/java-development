import java.time.LocalTime;

public class HotelOperations3 {

    public static void main(String[] args) {


        Employee employee1 = new Employee(1,"Adam","Meat Wall", 15.0);
        employee1.punchIn();
        employee1.punchOut();
        System.out.printf("%.2f\n",employee1.getHoursWorked());

        Hotel hotel1 = new Hotel("Adonis", 4,12);
        System.out.println(hotel1.bookRoom(2,true));
        System.out.println(hotel1.bookRoom(4,false));
        System.out.println("Suites Available " + hotel1.getAvailableSuits());
        System.out.println("Rooms Available " + hotel1.getAvailableRooms());

    }


    public static class Room {
        private int numberOfBeds;
        private double price;
        private boolean occupied;
        private boolean dirty;

        public Room(int numberOfBeds, double price/*, boolean occupied, boolean dirty*/) {
            this.numberOfBeds = numberOfBeds;
            this.price = price;
            this.occupied = false;
            this.dirty = true;
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

        public void checkIn() {
            if (isAvailable()){
                this.occupied = true;
                this.dirty = true;
            } else {
                System.out.println("Room not available");
            }

        }

        public void checkOut() {
            this.occupied = false;
        }

        public void cleanRoom() {
            this.dirty = false;
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
        private double clockIn;

        public Employee(int employeeId, String name, String department, double payRate/*, double hoursWorked*/){
            this.employeeId=employeeId;
            this.name=name;
            this.department=department;
            this.payRate=payRate;
            //this.hoursWorked=hoursWorked;

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

        public double getHoursWorked() {
            return hoursWorked;
        }

        public void punchIn(double time){
            this.clockIn=time;
        }

        public void punchIn() {
            LocalTime time = LocalTime.now();
            double hours = time.getHour();
            double minutes = (double) time.getMinute() /100;

            this.clockIn = hours+minutes;
        }

        public void punchOut(double time) {
            hoursWorked+=time-clockIn;
        }

        public void punchOut() {
            LocalTime time = LocalTime.now();
            double hours = time.getHour();
            double minutes = (double) time.getMinute() /100;
            double punchOutTime = hours+minutes;

            hoursWorked+=punchOutTime-clockIn;
        }

        public void punchTimeCard(double punchIn, double punchOut) {
            hoursWorked += (punchOut-punchIn);
        }

        public double getTotalPay() {
            double totalPay;
            if (getOvertimeHours()>0) {
                return (payRate * getRegularHours())+(((payRate*1.5))*getOvertimeHours());
            }
            return payRate*getRegularHours();
        }
    }

    public static class Hotel {
        private String name;
        private int numberOfRooms;
        private int numberOfSuites;
        private int bookedSuites;
        private int bookedRooms;

        public Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedSuites, int bookedRooms){
            this.name = name;
            this.numberOfRooms=numberOfRooms;
            this.numberOfSuites=numberOfSuites;
            this.bookedSuites=bookedSuites;
            this.bookedRooms=bookedRooms;
        }

        public Hotel(String name, int numberOfSuites, int numberOfRooms){
            this.name=name;
            this.numberOfSuites=numberOfSuites;
            this.numberOfRooms=numberOfRooms;
            this.bookedSuites=0;
            this.bookedRooms=0;
        }

        // Derived getters

        // Allows users to book multiple rooms at a time and choose between a suite or a basic room
        public boolean bookRoom(int numberOfRooms, boolean isSuite){
            // If the room is a suite
            if (isSuite){
                // If the number of suites the user wishes to book are available
                if ((this.numberOfSuites-this.bookedSuites)>=numberOfRooms){
                    // Update the number of booked suits
                    this.bookedSuites+=numberOfRooms;
                    // And return true
                    return true;
                } else { // If the
                    return false;
                }
            }
            if ((this.numberOfRooms-this.bookedRooms) >= numberOfRooms) {
                this.bookedRooms+=numberOfRooms;
                return true;
            } else{
                return false;
            }
        }

        public int getAvailableSuits(){
            return (this.numberOfSuites-this.bookedSuites);
        }

        public int getAvailableRooms(){
            return (this.numberOfRooms-this.bookedRooms);
        }
    }
}
