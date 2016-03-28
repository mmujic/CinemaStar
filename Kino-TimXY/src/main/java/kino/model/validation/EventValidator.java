package kino.model.validation;

import kino.model.entities.Event;

public class EventValidator {

    public static boolean isInvalidMovie(Event event) {
        if (event.getName() == null || event.getName().equals("") || !CommonValidators.isValidName(event.getName())) {
            return true;
        }
        if (event.getDescription() == null || event.getDescription().equals("") || !CommonValidators.isValidName(event.getName())) {
            return true;
        } else
            return false;
    }
}
