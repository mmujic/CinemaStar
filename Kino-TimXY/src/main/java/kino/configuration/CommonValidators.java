package kino.configuration;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonValidators {

    public static boolean isValidName(String name) {

        String regex = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }

    public static boolean isValidAddress(String name) {

        String regex = "^[\\p{L} ,]+[0-9]$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }

    public static boolean isValidEmail(String email) {
        boolean result = true;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isValidPhoneNumber(String phoneNo) {
        if (phoneNo.matches("\\d{10}")) {
            return true;
        } else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return true;
        } else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            return true;
        } else {
            return false;
        }
    }
}
