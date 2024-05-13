package com.addressbook.test;

import com.addressbook.app.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestContact {

    private Contact testContact;

    @Nested
    @DisplayName("Statement 1 Tests - Adding a contact")
    public class Statement1Tests {

        @BeforeEach
        public void setUp() {
            testContact = new Contact("Test contact", "07875647264", "testContact@gmail.com");
        }

        @Test
        public void testIfContactStoresCorrectInformation() {
            // Arrange
            // Act
            // Assert
            assertAll(
                    () -> assertEquals("Test contact", testContact.getName()),
                    () -> assertEquals("07875647264", testContact.getPhoneNumber()),
                    () -> assertEquals("testContact@gmail.com", testContact.getEmail())
            );
        }

        @Test
        public void testIfContactDoesntStoreNullOrEmptyStrings() {
            // Arrange
            // Act
            // Assert
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> new Contact("", "", "")),
                    () -> assertThrows(IllegalArgumentException.class, () -> new Contact(" ", "  ", "    ")),
                    () -> assertThrows(IllegalArgumentException.class, () -> new Contact(null, null, null))
            );
        }
    }
}
