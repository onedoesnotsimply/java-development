package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn_should_save_to_clockIn() {
        // Arrange
        Employee employee = new Employee(1, "Emily", "Developer", 30.2);
        double punchInTime = 6.5;


        // Act
        employee.punchIn(punchInTime);

        // Assert
        double actualTime = employee.getClockIn();
        assertEquals(punchInTime, actualTime);
    }

    @Test
    void punchOut_should_calculate_time_correctly() {
        // Arrange
        // Create an employee object
        Employee employee = new Employee(1, "Emily", "Developer",25.75);
        // Create variables
        double punchInTime = 6.5; // Punched in at 6:30
        double punchOutTime = 12.5; // Punched out at 12:30
        double expectedHours = 6; // hoursWorked should be 6.0;
        employee.punchIn(punchInTime);

        // Act
        employee.punchOut(punchOutTime);

        // Assert
        double actualHours = employee.getHoursWorked();
        assertEquals(expectedHours, actualHours);
    }
}