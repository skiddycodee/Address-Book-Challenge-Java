package com.addressbook.test;

import com.addressbook.app.AddressBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



    }
}
