package com.addressbook.app;

import com.addressbook.app.utils.StringUtils;
import java.util.ArrayList;

public class AddressBook {

    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber, String email) {
        checkIfContactExists(name.toLowerCase(), phoneNumber, email.toLowerCase());
        if (!StringUtils.checkIfName(name) || !StringUtils.checkIfPhoneNumber(phoneNumber) || !StringUtils.checkIfEmail(email)) {
            throw new IllegalArgumentException("Contact information not valid");
        }
        Contact contact = new Contact(name.toLowerCase(), phoneNumber, email.toLowerCase());
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void removeContact(String input) {
        String attributeType = checkIfNameOrPhoneNumberOrEmail(input);

        switch (attributeType) {
            case "email":
                removeByEmail(input.toLowerCase());
                break;
            case "phoneNumber":
                removeByPhoneNumber(input);
                break;
            case "name":
                removeByName(input.toLowerCase());
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
        throw new IllegalArgumentException("Not of type email, phone number or name");
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
            if (contact.getName().equals(currentName.toLowerCase()) && contact.getPhoneNumber().equals(currentPhoneNumber) && contact.getEmail().equals(currentEmail.toLowerCase())) {
                checkIfContactExists(newName.toLowerCase(), newPhoneNumber, newEmail.toLowerCase());
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

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber() + ", Email: " + contact.getEmail());
        }
    }
}
