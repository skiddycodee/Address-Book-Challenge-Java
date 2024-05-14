package com.addressbook.app;

public class Contact {

    private final String name;
    private final String phoneNumber;
    private final String email;

    public Contact(String name, String phoneNumber, String email) {
        contactInputQuarantine(name);
        contactInputQuarantine(phoneNumber);
        contactInputQuarantine(email);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    private void contactInputQuarantine(String input) {
        if (input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("Contact information cannot be null or empty");
        }
    }
}
