package com.addressbook.app;

import com.addressbook.app.utils.StringUtils;

public class Contact {

    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        StringUtils.contactInputQuarantine(name);
        StringUtils.contactInputQuarantine(phoneNumber);
        StringUtils.contactInputQuarantine(email);
        this.name = name.toLowerCase();
        this.phoneNumber = phoneNumber;
        this.email = email.toLowerCase();
    }

    public String getName() {
        return this.name.toLowerCase();
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email.toLowerCase();
    }

    public void setName(String name) {
        StringUtils.contactInputQuarantine(name);
        this.name = name.toLowerCase();
    }

    public void setPhoneNumber(String phoneNumber) {
        StringUtils.contactInputQuarantine(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        StringUtils.contactInputQuarantine(email);
        this.email = email.toLowerCase();
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Phone Number: " + this.phoneNumber + ", Email: " + this.email;
    }

}
