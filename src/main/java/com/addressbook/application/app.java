package com.addressbook.application;

import com.addressbook.app.AddressBook;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        //? Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        //? Application start
        System.out.println("Welcome to the Address Book Application");
        AddressBook addressBook = new AddressBook();

        //? Loop to keep the application running until the user decides to exit
        boolean exit = false;
        while (!exit) {
            //? Display the options to the user with method call
            optionMenu();
            //? Check if the user input is an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();

            //? Switch statement to handle the user input
            switch (option) {

                //? Case 1 - Add a contact
                case 1:
                    System.out.println("Enter the name of the contact");
                    String name = scanner.nextLine();
                    System.out.println("Enter the phone number of the contact");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter the email of the contact");
                    String email = scanner.nextLine();
                    System.out.println("Adding contact, Please Wait...");
                    //? Try to add the contact, catch the exception
                    try {
                        addressBook.addContact(name, phoneNumber, email);
                        System.out.println("Contact added successfully");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //? Case 2 - Remove a contact
                case 2:
                    System.out.println("Enter the name, phone number or email of the contact you would like to remove");
                    String input = scanner.nextLine();
                    System.out.println("Removing contact, Please Wait...");
                    //? Try to remove the contact, catch the exception
                    try {
                        addressBook.removeContact(input);
                        System.out.println("Contact removed successfully");
                    } catch(IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //? Case 3 - Edit a contact
                case 3:
                    System.out.println("Enter the name of the contact you would like to edit");
                    String currentName = scanner.nextLine();
                    System.out.println("Enter the phone number of the contact you would like to edit");
                    String currentPhoneNumber = scanner.nextLine();
                    System.out.println("Enter the email of the contact you would like to edit");
                    String currentEmail = scanner.nextLine();
                    System.out.println("Enter the contacts new name");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the contacts new phone number");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.println("Enter the contacts new email");
                    String newEmail = scanner.nextLine();
                    System.out.println("Editing contact, Please Wait...");
                    //? Try to edit the contact, catch the exception
                    try {
                        addressBook.editContact(currentName, currentPhoneNumber, currentEmail, newName, newPhoneNumber, newEmail);
                        System.out.println("Contact edited successfully");
                    } catch(IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //? Case 4 - View all contacts
                case 4:
                    System.out.println("Printing Contacts, Please Wait...");
                    addressBook.printContacts();
                    break;

                //? Case 5 - Exit
                case 5:
                    System.out.println("Exiting the application");
                    exit = true;
                    break;

                //? Default case - Invalid option
                default:
                    System.out.println("Invalid option, please try again");
            }
        }


    }

    private static void optionMenu() {
        System.out.println("What would you like to do? (Enter the number of the option you would like to select)");
        System.out.println("1. Add a contact");
        System.out.println("2. Remove a contact");
        System.out.println("3. Edit a contact");
        System.out.println("4. View all contacts");
        System.out.println("5. Exit");
    }
}
