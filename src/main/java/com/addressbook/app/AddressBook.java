package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {

    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber, String email) {
        Contact contact = new Contact(name, phoneNumber, email);
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void removeContact(String input) {
        String attributeType = checkIfNameOrPhoneNumberOrEmail(input);

        switch (attributeType) {
            case "name":
                removeByName(input);
                break;
            case "phoneNumber":
                removeByPhoneNumber(input);
                break;
            case "email":
                removeByEmail(input);
                break;
            default:
                throw new IllegalArgumentException("Contact not valid");
        }
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

    public void removeByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact phone number not found");
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

    /**
    * TODO: Move the following methods to a utils class
     * Method checkIfNameOrPhoneNumberOrEmail
     * Method checkIfName
     * Method checkIfPhoneNumber
     * Method checkIfEmail
     * Method contactInputQuarantine
    */

    public String checkIfNameOrPhoneNumberOrEmail(String input) {
        if (checkIfEmail(input)) {
            return "email";
        }
        if (checkIfPhoneNumber(input)) {
            return "phoneNumber";
        }
        if (checkIfName(input)) {
            return "name";
        }
        return input;
    }

    public boolean checkIfName(String input) {
        return contactInputQuarantine(input);
    }

    public boolean checkIfPhoneNumber(String input) {
        String phoneNumberRegex = "^\\+?(\\d[\\d-. ]+)?(\\([\\d-. ]+\\))?[\\d-. ]+\\d$";
        return contactInputQuarantine(input) && input.matches(phoneNumberRegex);
    }

    public boolean checkIfEmail(String input) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return contactInputQuarantine(input) && input.matches(emailRegex);
    }

    private boolean contactInputQuarantine(String input) {
        return input != null && !input.trim().isEmpty();
    }


}
