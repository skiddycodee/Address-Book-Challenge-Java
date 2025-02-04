package com.addressbook.app.utils;

public abstract class StringUtils {

    /**
     * Method to check if the input is a name
     * @param input - name of the contact
     *
     * @return boolean - true if the input is a name
     *
     * @throws IllegalArgumentException if the input is null or empty
     */
    public static boolean checkIfName(String input) {
        return contactInputQuarantine(input);
    }

    /**
     * Method to check if the input is a phone number
     * @param input - phone number of the contact
     *
     * @return boolean - true if the input is a phone number
     *
     * @throws IllegalArgumentException if the input is null or empty
     */
    public static boolean checkIfPhoneNumber(String input) {
        //? Regular expression for phone number validation
        //? Was originally wrote by me, however to fit different
        //? phone number formats, I had to use a different regex
        //? generated by AI
        String phoneNumberRegex = "^(?!.*--.*)(?!.*\\.-.*)(?!.*-\\..*)(?!.*\\.\\..*)\\+?\\(?\\d[\\d-. ]+\\)?[-. ]?(\\([\\d-. ]+\\))?[\\d-. ]+\\d$";
        return contactInputQuarantine(input) && input.matches(phoneNumberRegex);
    }

    /**
     * Method to check if the input is an email
     * @param input - email of the contact
     *
     * @return boolean - true if the input is an email
     *
     * @throws IllegalArgumentException if the input is null or empty
     */
    public static boolean checkIfEmail(String input) {
        //? Regular expression for email address validation
        //? Was originally wrote by me, however to fit different
        //? email formats, I had to use a different regex
        //? generated by AI
        String emailRegex = "^(?=[^@]*@[^@]*$)(?!\\.)[A-Za-z0-9+_.-]+(?<!\\.)@((?!\\..*\\.)[A-Za-z0-9][A-Za-z0-9_.-]*[A-Za-z0-9]\\.)+[A-Za-z]{2,6}$";
        return contactInputQuarantine(input) && input.matches(emailRegex);
    }

    /**
     * Method to check if the input is a name, phone number or email
     * @param input - name, phone number or email of the contact
     *
     * @return boolean - true if the input is a name, phone number or email
     *
     * @throws IllegalArgumentException if the input is not of type email, phone number or name
     */
    public static boolean contactInputQuarantine(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact information cannot be null or empty");
        }
        return true;
    }

}
