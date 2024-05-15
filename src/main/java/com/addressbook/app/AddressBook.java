package com.addressbook.app;

import com.addressbook.app.utils.StringUtils;
import java.util.ArrayList;

public class AddressBook {

    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber, String email) {
        checkIfContactExists(name, phoneNumber, email);
        Contact contact = new Contact(name, phoneNumber, email);
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void removeContact(String input) {
        String attributeType = checkIfNameOrPhoneNumberOrEmail(input);

        switch (attributeType) {
            case "email":
                removeByEmail(input);
                break;
            case "phoneNumber":
                removeByPhoneNumber(input);
                break;
            case "name":
                removeByName(input);
                break;
            default:
                throw new IllegalArgumentException("Contact not valid");
        }
    }

    public String checkIfNameOrPhoneNumberOrEmail(String input) {
        if (StringUtils.checkIfEmail(input)) {
            return "email";
        }
        if (StringUtils.checkIfPhoneNumber(input)) {
            return "phoneNumber";
        }
        if (StringUtils.checkIfName(input)) {
            return "name";
        }
        return input;
    }

    public void removeByEmail(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact email not found");
    }

    public void removeByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact phone number not found");
    }

    public void removeByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact name not found");
    }

    public void editContact(String currentName, String currentPhoneNumber, String currentEmail, String newName, String newPhoneNumber, String newEmail) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(currentName) && contact.getPhoneNumber().equals(currentPhoneNumber) && contact.getEmail().equals(currentEmail)) {
                checkIfContactExists(newName, newPhoneNumber, newEmail);
                contact.setName(newName);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");

    }

    public void checkIfContactExists(String name, String phoneNumber, String email) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name) && contact.getPhoneNumber().equals(phoneNumber) && contact.getEmail().equals(email)) {
                throw new IllegalArgumentException("Contact already exists");
            }
        }
    }
}
