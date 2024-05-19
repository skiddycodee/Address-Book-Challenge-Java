package com.addressbook.app;

import com.addressbook.app.utils.StringUtils;

public class Contact {

    private String name;
    private String phoneNumber;
    private String email;

    /** Constructor for the Contact class
     * @param name - name of the contact
     * @param phoneNumber - phone number of the contact
     * @param email - email of the contact
     *
     * @throws IllegalArgumentException if the contact information is null or empty
     */
    public Contact(String name, String phoneNumber, String email) {
        StringUtils.contactInputQuarantine(name);
        StringUtils.contactInputQuarantine(phoneNumber);
        StringUtils.contactInputQuarantine(email);
        this.name = name.toLowerCase();
        this.phoneNumber = phoneNumber;
        this.email = email.toLowerCase();
    }

    /** Method to get the name of the contact
     * @return String - name of the contact
     */
    public String getName() {
        return this.name.toLowerCase();
    }

    /** Method to get the phone number of the contact
     * @return String - phone number of the contact
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /** Method to get the email of the contact
     * @return String - email of the contact
     */
    public String getEmail() {
        return this.email.toLowerCase();
    }

    /** Method to set the name of the contact
     * @param name - name of the contact
     *
     * @throws IllegalArgumentException if the contact name is null or empty
     */
    public void setName(String name) {
        StringUtils.contactInputQuarantine(name);
        this.name = name.toLowerCase();
    }

    /** Method to set the phone number of the contact
     * @param phoneNumber - phone number of the contact
     *
     * @throws IllegalArgumentException if the contact phone number is null or empty
     */
    public void setPhoneNumber(String phoneNumber) {
        StringUtils.contactInputQuarantine(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /** Method to set the email of the contact
     * @param email - email of the contact
     *
     * @throws IllegalArgumentException if the contact email is null or empty
     */
    public void setEmail(String email) {
        StringUtils.contactInputQuarantine(email);
        this.email = email.toLowerCase();
    }

    /** toString method override
     * @return String - contact information in string format
     */
    @Override
    public String toString() {
        return "Name: " + this.name + ", Phone Number: " + this.phoneNumber + ", Email: " + this.email;
    }

}
