package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

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