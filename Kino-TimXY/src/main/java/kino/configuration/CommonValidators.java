package kino.configuration;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonValidators {

    public static boolean isValidName(String name) {

        String regex = "^[a-zA-ZćčšđžĆČĐŠŽ .'-]+$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }

    public static boolean isValidAddress(String name) {

        String regex = "^[\\p{L} ,]+[0-9]+$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }

    public static boolean isValidEmail(String name) {

        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }

    public static boolean isValidPhoneNumber(String phoneNo) {
        if (phoneNo.matches("\\d+")) {
            return true;
        } else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}")) {
            return true;
        } else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{3}")) {
            return true;
        } else {
            return false;
        }
    }
}
