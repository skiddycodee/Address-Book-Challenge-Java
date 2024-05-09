package com.addressbook.app;

public class Contact {

    private

    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
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


    @Override
    public String toString() {
        return "{" +
                name + ", " +
                phoneNumber + ", " +
                email +
                "}";
    }
}
