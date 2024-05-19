package com.addressbook.app;

import com.addressbook.app.utils.StringUtils;
import java.util.ArrayList;

public class AddressBook {

    //? ArrayList to store Contact objects
    private final ArrayList<Contact> contacts = new ArrayList<>();

    /** Method to add a contact to the address book
     * @param name - name of the contact
     * @param phoneNumber - phone number of the contact
     * @param email - email of the contact
     *
     * @throws IllegalArgumentException if the contact already exists or if the contact information is not valid
     */
    public void addContact(String name, String phoneNumber, String email) {
        checkIfContactExists(name.toLowerCase(), phoneNumber, email.toLowerCase());
        if (!StringUtils.checkIfName(name) || !StringUtils.checkIfPhoneNumber(phoneNumber) || !StringUtils.checkIfEmail(email)) {
            throw new IllegalArgumentException("Contact information not valid");
        }
        Contact contact = new Contact(name.toLowerCase(), phoneNumber, email.toLowerCase());
        this.contacts.add(contact);
    }

    /** Testing method to get the contacts in the address book
     * @return ArrayList of Contact objects
     */
    public ArrayList<Contact> getContacts() {return this.contacts;}

    /** Method to remove a contact from the address book
     * @param input - name, phone number or email of the contact to be removed
     *
     * @throws IllegalArgumentException if the contact does not exist or if the contact information is not valid
     */
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

    /** Method to check if the input is a name, phone number or email
     * @param input - name, phone number or email of the contact
     *
     * @return String - "name", "phoneNumber" or "email"
     *
     * @throws IllegalArgumentException if the input is not of type email, phone number or name
     */
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

    /** Method to remove a contact by email
     * @param email - email of the contact to be removed
     *
     * @throws IllegalArgumentException if the contact email is not found
     */
    public void removeByEmail(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact email not found");
    }

    /** Method to remove a contact by phone number
     * @param phoneNumber - phone number of the contact to be removed
     *
     * @throws IllegalArgumentException if the contact phone number is not found
     */
    public void removeByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact phone number not found");
    }

    /** Method to remove a contact by name
     * @param name - name of the contact to be removed
     *
     * @throws IllegalArgumentException if the contact name is not found
     */
    public void removeByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contacts.remove(contact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact name not found");
    }

    /** Method to edit a contact in the address book
     * @param currentName - current name of the contact
     * @param currentPhoneNumber - current phone number of the contact
     * @param currentEmail - current email of the contact
     * @param newName - new name of the contact
     * @param newPhoneNumber - new phone number of the contact
     * @param newEmail - new email of the contact
     *
     * @throws IllegalArgumentException if the contact does not exist
     */
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

    /** Method to check if a contact already exists in the address book
     * @param name - name of the contact
     * @param phoneNumber - phone number of the contact
     * @param email - email of the contact
     *
     * @throws IllegalArgumentException if the contact already exists
     */
    public void checkIfContactExists(String name, String phoneNumber, String email) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name) && contact.getPhoneNumber().equals(phoneNumber) && contact.getEmail().equals(email)) {
                throw new IllegalArgumentException("Contact already exists");
            }
        }
    }

    /** Method to print all contacts in the address book
     */
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
