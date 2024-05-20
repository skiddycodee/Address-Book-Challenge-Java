package com.addressbook.test;

import com.addressbook.app.AddressBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
                    () -> assertEquals("test contact", testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals("test contact 2", testAddressBook.getContacts().get(1).getName()),
                    () -> assertEquals("test contact 3", testAddressBook.getContacts().get(2).getName()),
                    () -> assertEquals("test contact 4", testAddressBook.getContacts().get(3).getName()),
                    () -> assertEquals("07875647264", testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("07875647265", testAddressBook.getContacts().get(1).getPhoneNumber()),
                    () -> assertEquals("07875647266", testAddressBook.getContacts().get(2).getPhoneNumber()),
                    () -> assertEquals("07875647267", testAddressBook.getContacts().get(3).getPhoneNumber()),
                    () -> assertEquals("testcontact@gmail.com", testAddressBook.getContacts().get(0).getEmail()),
                    () -> assertEquals("testcontact2@gmail.com", testAddressBook.getContacts().get(1).getEmail()),
                    () -> assertEquals("testcontact3@gmail.com", testAddressBook.getContacts().get(2).getEmail()),
                    () -> assertEquals("testcontact4@gmail.com", testAddressBook.getContacts().get(3).getEmail())
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testAddingContactWithSpecialCharacters() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            // Act
            testAddressBook.addContact("Test @Contact", "+44 7875-647-264", "test.contact+1@gmail.com");
            // Assert
            assertAll(
                    () -> assertEquals(1, testAddressBook.getContacts().size()),
                    () -> assertEquals("test @contact", testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals("+44 7875-647-264", testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("test.contact+1@gmail.com", testAddressBook.getContacts().get(0).getEmail())
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testAddingContactWithVeryLongDetails() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            String longName = "a".repeat(256);
            String longPhoneNumber = "0".repeat(20);
            String longEmail = "a".repeat(100) + "@gmail.com";
            // Act
            testAddressBook.addContact(longName, longPhoneNumber, longEmail);
            // Assert
            assertAll(
                    () -> assertEquals(1, testAddressBook.getContacts().size()),
                    () -> assertEquals(longName, testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals(longPhoneNumber, testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals(longEmail, testAddressBook.getContacts().get(0).getEmail())
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
            testAddressBook.addContact("Test contact 2", "07875647265", "testContact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testContact3@gmail.com");
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
                    () -> assertEquals("test contact", testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals("test contact 3", testAddressBook.getContacts().get(1).getName()),
                    () -> assertEquals("07875647264", testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("07875647266", testAddressBook.getContacts().get(1).getPhoneNumber()),
                    () -> assertEquals("testcontact@gmail.com", testAddressBook.getContacts().get(0).getEmail()),
                    () -> assertEquals("testcontact3@gmail.com", testAddressBook.getContacts().get(1).getEmail())
            );
        }

        @Test
        public void ensureRemovalByEmail() {
            // Arrange
            testAddressBook.addContact("Test contact 2", "07875647265", "testContact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testContact3@gmail.com");
            // Act
            testAddressBook.removeContact("testContact@gmail.com");
            testAddressBook.removeContact("testContact2@gmail.com");
            testAddressBook.removeContact("testContact3@gmail.com");
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        public void ensureRemovalByPhoneNumber() {
            // Arrange
            testAddressBook.addContact("Test contact 2", "07875647265", "testContact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testContact3@gmail.com");
            // Act
            testAddressBook.removeContact("07875647264");
            testAddressBook.removeContact("07875647265");
            testAddressBook.removeContact("07875647266");
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        public void ensureContactArrayDoesNotDecrementWhenContactNotFound() {
            // Arrange
            // Act
            // Assert
            assertAll(
                    () -> assertEquals(1, testAddressBook.getContacts().size()),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact("Invalid contact"))
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testRemovingContactFromEmptyAddressBook() {
            // Arrange
            AddressBook emptyAddressBook = new AddressBook();
            // Act & Assert
            assertThrows(IllegalArgumentException.class, () -> emptyAddressBook.removeContact("Nonexistent Contact"));
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testRemovingContactWithMixedCaseInput() {
            // Arrange
            testAddressBook.addContact("Case Sensitive", "07875647268", "casesensitive@gmail.com");
            // Act
            testAddressBook.removeContact("cASE sENSITIVE");
            // Assert
            assertEquals(1, testAddressBook.getContacts().size());
        }

    }


    @Nested
    class Statement4Tests {

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
        }

        @Test
        public void testIfAContactsDetailsCanBeEdited() {
            // Arrange
            // Act
            testAddressBook.editContact("Test contact", "07875647264", "testContact@gmail.com",
                    "New Contact", "07875647265", "newContact@gmail.com");
            // Assert
            assertAll(
                    () -> assertEquals("new contact", testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals("07875647265", testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("newcontact@gmail.com", testAddressBook.getContacts().get(0).getEmail())
            );
        }

        @Test
        public void unableToEditContactIfContactNotFound() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("unfound Contact", "07123456789", "unfoundEmail@gmail.com",
                    "New Contact", "07875647265", "newContact@gmail.com"));
        }

        @Test
        public void unableToEditContactIfAnyContactDetailsAreInvalid() {
            // Arrange
            // Act
            // Assert
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Test contact", "07875647263", "testContact@gmail.com",
                            "New Contact", "07875647265", "newContact@gmail.com")),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Tesst contact", "07875647264", "testContact@gmail.com",
                            "New Contact", "07875647265", "newContact@gmail.com")),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Test contact", "07875647264", "tesstContact@gmail.com",
                            "New Contact", "07875647265", "newContact@gmail.com"))
            );
        }

        @Test
        public void unableToChangeAContactsDetailsToNullOrEmptyOrWhitespace() {
            // Arrange
            // Act
            // Assert
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Test contact", "07875647263", "testContact@gmail.com",
                            null, null, null)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Tesst contact", "07875647264", "testContact@gmail.com",
                            "", "", "")),
                    () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Test contact", "07875647264", "tesstContact@gmail.com",
                            " ", "     ", "                         "))
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testEditingContactWithPartialMatch() {
            // Arrange
            // Act & Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Test ", "07875647264", "testContact@gmail.com",
                    "New Contact", "07875647265", "newContact@gmail.com"));
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testEditingContactWithMinimalChange() {
            // Arrange
            // Act
            testAddressBook.editContact("Test contact", "07875647264", "testContact@gmail.com",
                    "Test contact", "07875647264", "testContactUpdated@gmail.com");
            // Assert
            assertAll(
                    () -> assertEquals("test contact", testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals("07875647264", testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("testcontactupdated@gmail.com", testAddressBook.getContacts().get(0).getEmail())
            );
        }


    }

    @Nested
    class Statement5Tests {

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
        }

        @Test
        public void ensureICannotAddDuplicateContacts() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com"));
        }

        @Test
        public void ensureICannotEditAContactToBeADuplicate() {
            // Arrange
            // Act
            testAddressBook.addContact("Test contact 2", "07875647265", "testContact2@gmail.com");
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact("Test contact 2", "07875647265", "testContact2@gmail.com",
                    "Test contact", "07875647264", "testContact@gmail.com"));
        }

        @Test
        public void ensureICanAddAContactWithTheSameDetailsAsADeletedContact() {
            // Arrange
            // Act
            testAddressBook.removeContact("Test contact");
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
            // Assert
            assertAll(
                    () -> assertEquals(1, testAddressBook.getContacts().size()),
                    () -> assertEquals("test contact", testAddressBook.getContacts().get(0).getName()),
                    () -> assertEquals("07875647264", testAddressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("testcontact@gmail.com", testAddressBook.getContacts().get(0).getEmail())
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testAddingContactWithSameNameDifferentDetails() {
            // Arrange
            // Act
            testAddressBook.addContact("Test contact", "07875647269", "testContact2@gmail.com");
            // Assert
            assertEquals(2, testAddressBook.getContacts().size());
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testEditingContactWithSameNameDifferentDetails() {
            // Arrange
            testAddressBook.addContact("Test contact 3", "07875647269", "testContact3@gmail.com");
            // Act
            testAddressBook.editContact("Test contact 3", "07875647269", "testContact3@gmail.com",
                    "Test contact", "07875647270", "testContact4@gmail.com");
            // Assert
            assertEquals(2, testAddressBook.getContacts().size());
        }
    }

    @Nested
    class Statement6Tests {

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            testAddressBook.addContact("Test contact", "07875647264", "testContact@gmail.com");
            testAddressBook.addContact("Test contact 2", "07875647265", "testContact2@gmail.com");
            testAddressBook.addContact("Test contact 3", "07875647266", "testContact3@gmail.com");
            testAddressBook.addContact("Test contact 4", "07875647267", "testContact4@gmail.com");
        }

        @Test
        public void contactsPrintedToConsoleMatchContactCount() {
            // Arrange
            // Act
            testAddressBook.printContacts();
            // Assert
            assertEquals(4, testAddressBook.getContacts().size());
        }

        @Test
        public void printedContactInfoIsCorrect() {
            // Arrange
            // Act
            testAddressBook.printContacts();
            // Assert
            assertAll(
                    () -> assertEquals("Name: test contact, Phone Number: 07875647264, Email: testcontact@gmail.com", testAddressBook.getContacts().get(0).toString()),
                    () -> assertEquals("Name: test contact 2, Phone Number: 07875647265, Email: testcontact2@gmail.com", testAddressBook.getContacts().get(1).toString()),
                    () -> assertEquals("Name: test contact 3, Phone Number: 07875647266, Email: testcontact3@gmail.com", testAddressBook.getContacts().get(2).toString()),
                    () -> assertEquals("Name: test contact 4, Phone Number: 07875647267, Email: testcontact4@gmail.com", testAddressBook.getContacts().get(3).toString())
            );
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testPrintingEmptyAddressBook() {
            // Arrange
            AddressBook emptyAddressBook = new AddressBook();
            // Act & Assert
            assertDoesNotThrow(() -> emptyAddressBook.printContacts());
        }

        //? AI generated edge/corner case test
        //? Test prompted with current code and tests and asked for 2 additional edge/corner case tests
        @Test
        public void testPrintingContactWithVeryLongDetails() {
            // Arrange
            String longName = "a".repeat(256);
            String longPhoneNumber = "0".repeat(20);
            String longEmail = "a".repeat(100) + "@gmail.com";
            testAddressBook.addContact(longName, longPhoneNumber, longEmail);
            // Act & Assert
            assertDoesNotThrow(() -> testAddressBook.printContacts());
        }

    }
}


