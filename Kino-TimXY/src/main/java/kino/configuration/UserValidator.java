package kino.configuration;

import kino.model.entities.User;

public class UserValidator {

    public static boolean isInvalidUser(User user) {

        if(user.getName() == null || user.getName().equals("") || !CommonValidators.isValidName(user.getName())) {
            return false;
        }

        if(user.getAddress() == null || user.getAddress().equals("") || !CommonValidators.isValidAddress(user.getAddress())) {
            return false;
        }

        if(user.getEmail() == null || user.getEmail().equals("") || !CommonValidators.isValidEmail(user.getEmail())) {
            return false;
        }

        if(user.getNumber() == null || user.getNumber().equals("") || !CommonValidators.isValidPhoneNumber(user.getNumber())) {
            return false;
        }

        return true;
    }

}
