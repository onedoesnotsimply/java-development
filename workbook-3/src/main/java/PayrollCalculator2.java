import java.io.*;
import java.util.Scanner;

public class PayrollCalculator2 {
    /*
    Allows user to calculate the gross pay of employees by reading from a csv file.
    Writes the results to a new csv file.
     */

    // Create scanner object for prompting
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Prompt user for a filename
        System.out.println("Enter the name of the file employee file to process: ");
        String fileName = scanner.nextLine();
        // Prompt for created filename
        System.out.println("Enter the name of the payroll file to create: ");
        String newFileName = scanner.nextLine();

        try {
            // Create a file reader/buffer
            BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
            // Create a file writer/buffer
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(newFileName));

            String line;
            boolean hasHeader = false;

            while ((line = bufReader.readLine()) != null){
                if (!hasHeader) { // Check for the header
                    bufWriter.write("id|name|gross pay\n"); // Write your header
                    hasHeader = true; // Change it to true
                    continue; // Skip the line
                }
                bufWriter.write(populateEmployee(line)+"\n"); // Write to your file
            }

            // Close the scanners/readers/writers
            bufReader.close();
            bufWriter.close();
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: filename not found");
        } catch (IOException e) {
            System.out.println("Error: invalid filename");
        }

    }

    // Creates and prints employee objects populated by the csv file
    static String populateEmployee(String input) {
        
        // Split the csv file lines
        String[] tokens = input.split("\\|");

        // Initialize the split variables, parsing from string
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        double hoursWorked = Double.parseDouble(tokens[2]);
        double payRate = Double.parseDouble(tokens[3]);

        // Populate the employees
        PayrollCalculator.Employee employee = new PayrollCalculator.Employee(id,name,hoursWorked,payRate);
        // Return the id|name|gross pay in csv format
        return String.format("%d|%s|%.2f",employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
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
            return payRate*hoursWorked;

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
