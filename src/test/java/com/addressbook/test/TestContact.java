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
                    () -> assertEquals("test contact", testContact.getName()),
                    () -> assertEquals("07875647264", testContact.getPhoneNumber()),
                    () -> assertEquals("testcontact@gmail.com", testContact.getEmail())
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

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testContactWithSpecialCharacters() {
            // Arrange & Act
            Contact specialContact = new Contact("Test@Contact", "+44-7875-647-264", "test.contact+1@gmail.com");

            // Assert
            assertAll(
                    () -> assertEquals("test@contact", specialContact.getName()),
                    () -> assertEquals("+44-7875-647-264", specialContact.getPhoneNumber()),
                    () -> assertEquals("test.contact+1@gmail.com", specialContact.getEmail())
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testContactWithVeryLongDetails() {
            // Arrange
            String longName = "a".repeat(256);
            String longPhoneNumber = "0".repeat(20);
            String longEmail = "a".repeat(100) + "@gmail.com";

            // Act
            Contact longContact = new Contact(longName, longPhoneNumber, longEmail);

            // Assert
            assertAll(
                    () -> assertEquals(longName.toLowerCase(), longContact.getName()),
                    () -> assertEquals(longPhoneNumber, longContact.getPhoneNumber()),
                    () -> assertEquals(longEmail.toLowerCase(), longContact.getEmail())
            );
        }
    }
}
