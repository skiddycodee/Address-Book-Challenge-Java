package com.addressbook.test;

import com.addressbook.app.AddressBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TestAddressBook {

    @Nested
    @DisplayName("Statement 1 Tests - Adding a contact")
    public class Statement1Tests {
        @Test
        public void testContactArrayIncrementsBy1WhenValidContactAdded() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            // Act
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
            // Assert
            assertEquals(1, testAddressBook.getContacts().size());
        }

        @Test
        public void testIfMultipleContactsCanBeAdded() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            // Act
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
            testAddressBook.addContact("Test contact 2", "07875647265", "testContact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testContact3@gmail.com");
            testAddressBook.addContact("Test contact 4", "07875647267", "testContact4@gmail.com");
            // Assert
            assertAll(
                    () -> assertEquals(4, testAddressBook.getContacts().size()),
                    () -> assertEquals("Test contact", testAddressBook.getContacts().getFirst().getName()),
                    () -> assertEquals("Test contact 2", testAddressBook.getContacts().get(1).getName()),
                    () -> assertEquals("Test contact 3", testAddressBook.getContacts().get(2).getName()),
                    () -> assertEquals("Test contact 4", testAddressBook.getContacts().get(3).getName()),
                    () -> assertEquals("07875647264", testAddressBook.getContacts().getFirst().getPhoneNumber()),
                    () -> assertEquals("07875647265", testAddressBook.getContacts().get(1).getPhoneNumber()),
                    () -> assertEquals("07875647266", testAddressBook.getContacts().get(2).getPhoneNumber()),
                    () -> assertEquals("07875647267", testAddressBook.getContacts().get(3).getPhoneNumber()),
                    () -> assertEquals("testContact@gmail.com", testAddressBook.getContacts().getFirst().getEmail()),
                    () -> assertEquals("testContact2@gmail.com", testAddressBook.getContacts().get(1).getEmail()),
                    () -> assertEquals("testContact3@gmail.com", testAddressBook.getContacts().get(2).getEmail()),
                    () -> assertEquals("testContact4@gmail.com", testAddressBook.getContacts().get(3).getEmail())
            );
        }

    }
}
