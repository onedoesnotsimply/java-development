import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {

    public static void main(String[] args) {

        // Try to create the file reader/buffer objects
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            //String[] tokens;
            boolean headerSkipped = false;

            // Read the file and populate the employee class
            while ((input = bufferedReader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                populateEmployee(input);

                //System.out.println(input);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void populateEmployee(String input) {
        // Creates and prints employee objects populated by the csv file
        String[] tokens = input.split("\\|");

        // Create a new employee object
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        double hoursWorked = Double.parseDouble(tokens[2]);
        double payRate = Double.parseDouble(tokens[3]);

        Employee employee = new Employee(id,name,hoursWorked,payRate);
        System.out.printf("%d, %s, makes $%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
    }


    public static class Employee {
        // Initialize attributes
        private int employeeId;
        private String name;
        private double hoursWorked;
        private double payRate;

        // Constructor
        public Employee(int employeeId, String name, double hoursWorked, double payRate) {
            this.employeeId = employeeId;
            this.name = name;
            this.hoursWorked = hoursWorked;
            this.payRate = payRate;
        }

        // Calculates and returns gross pay
        public double getGrossPay() {
            // Doesn't account for overtime pay
            return getPayRate()*getHoursWorked();

        }

        // Getters
        public int getEmployeeId() {
            return employeeId;
        }

        public double getHoursWorked() {
            return hoursWorked;
        }

        public String getName() {
            return name;
        }

        public double getPayRate() {
            return payRate;
        }

        // Setters
        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public void setHoursWorked(double hoursWorked) {
            this.hoursWorked = hoursWorked;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPayRate(double payRate) {
            this.payRate = payRate;
        }

    }
}
