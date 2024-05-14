package com.addressbook.test;

import com.addressbook.app.AddressBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAddressBook {

    private AddressBook testAddressBook;

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

    @Nested
    class Statement2Tests {

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
        }

        @Test
        public void testIfContactArraylistDecrementsBy1() {
            // Arrange
            // Act
            testAddressBook.removeContact("Test contact");
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        public void throwErrorIfRemovalInputIsNotValid() {
            // Arrange
            String invalidName = "";
            String invalidName2 = "null";
            String invalidName3 = " ";
            String invalidPhoneNumber = "07123456789";
            String invalidPhoneNumber2 = "null";
            String invalidPhoneNumber3 = " ";
            String invalidEmail = "invalidContact@gmail.com";
            String invalidEmail2 = "null";
            String invalidEmail3 = " ";
            // Act
            // Assert
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidName)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidName2)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidName3)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidPhoneNumber)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidPhoneNumber2)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidPhoneNumber3)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidEmail)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidEmail2)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(invalidEmail3))
            );
        }

        @Test
        public void throwErrorIfRemovalInputIsNotAContact() {
            // Arrange
            String fakeName = "Invalid Name";
            String fakePhoneNumber = "07123456789";
            String fakeEmail = "invalidContact@gmail.com";
            // Act
            // Assert
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(fakeName)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(fakePhoneNumber)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(fakeEmail))
                    );
        }

        @Test
        public void ensureMultipleContactsCanBeAdded() {
            // Arrange
            testAddressBook.addContact("Test contact 2", "07875647265", "testcontact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testcontact3@gmail.com");
            // Act
            testAddressBook.removeContact("Test contact");
            testAddressBook.removeContact("Test contact 2");
            testAddressBook.removeContact("Test contact 3");
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        public void ensureTheCorrectContactGetsRemoved() {
            // Arrange
            testAddressBook.addContact("Test contact 2", "07875647263", "testContact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testContact3@gmail.com");
            // Act
            testAddressBook.removeContact("Test contact 2");
            // Assert
            assertAll(
                    () -> assertEquals(2, testAddressBook.getContacts().size()),
                    () -> assertEquals("Test contact", testAddressBook.getContacts().getFirst().getName()),
                    () -> assertEquals("Test contact 3", testAddressBook.getContacts().get(1).getName()),
                    () -> assertEquals("07875647264", testAddressBook.getContacts().getFirst().getPhoneNumber()),
                    () -> assertEquals("07875647266", testAddressBook.getContacts().get(1).getPhoneNumber()),
                    () -> assertEquals("testContact@gmail.com", testAddressBook.getContacts().getFirst().getEmail()),
                    () -> assertEquals("testContact3@gmail.com", testAddressBook.getContacts().get(1).getEmail())
            );
        }

    }

}
