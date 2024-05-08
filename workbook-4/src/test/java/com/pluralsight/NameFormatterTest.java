package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void format_firstName_lastName_should_swap() {
        // Arrange
        String firstName = "Emily";
        String lastName = "Trifone";
        String expectedName = "Trifone, Emily";
        String actualName;

        // Set
        actualName = NameFormatter.format(firstName,lastName);

        // Assert
        assertEquals(actualName,expectedName);
    }

    @Test
    void format_individual_name_variables() {
        // Arrange
        String prefix = "Ms.";
        String firstName = "Emily";
        String middleName = "M";
        String lastName = "Trifone";
        String suffix = "III";
        String expectedName = "Trifone, Ms. Emily M, III";

        // Set
        String actualName = NameFormatter.format(prefix,firstName,middleName,lastName,suffix);

        // Assert
        assertEquals(actualName,expectedName);
    }

    @Test
    void format_fullName() {
        // Arrange
        String fullName = "Ms. Emily M Trifone, III";
        String expectedName = "Trifone, Ms. Emily M, III";

        // Set
        String actualName = NameFormatter.format(fullName);

        // Assert
        assertEquals(actualName,expectedName);
    }
}