package com.addressbook.test;

import com.addressbook.app.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContact {

    @Nested
    @DisplayName("Statement 1 Tests - Adding a contact")
    public class Statement1Tests {
        @Test
        public void testIfContactStoresCorrectInformation() {
            // Arrange
            Contact testContact = new Contact("Test contact", "07875647264", "testContact@gmail.com");
            // Act
            // Assert
            assertAll(
                    () -> assertEquals("Test contact", testContact.getName()),
                    () -> assertEquals("07875647264", testContact.getPhoneNumber()),
                    () -> assertEquals("testContact@gmail.com", testContact.getEmail())
            );
        }
    }
}
