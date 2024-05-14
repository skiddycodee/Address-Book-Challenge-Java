package com.addressbook.app.utils;

public abstract class StringUtils {

    public static boolean checkIfName(String input) {
        return contactInputQuarantine(input);
    }

    public static boolean checkIfPhoneNumber(String input) {
        String phoneNumberRegex = "^\\+?(\\d[\\d-. ]+)?(\\([\\d-. ]+\\))?[\\d-. ]+\\d$";
        return contactInputQuarantine(input) && input.matches(phoneNumberRegex);
    }

    public static boolean checkIfEmail(String input) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return contactInputQuarantine(input) && input.matches(emailRegex);
    }

    public static boolean contactInputQuarantine(String input) {
        return input != null && !input.trim().isEmpty();
    }

}
