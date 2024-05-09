package com.addressbook.app;

public class Contact {

    private final String name;
    private final String phoneNumber;
    private final String email;

    public Contact(String name, String phoneNumber, String email) {
        contactInputQuarantine(name, phoneNumber, email);
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

    private void contactInputQuarantine(String name, String phoneNumber, String email) {
        if (name == null || name.trim().isEmpty() ||
                phoneNumber == null || phoneNumber.trim().isEmpty() ||
                email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Contact information cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return "{" +
                name + ", " +
                phoneNumber + ", " +
                email +
                "}";
    }
}
