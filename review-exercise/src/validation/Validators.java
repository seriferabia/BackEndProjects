package validation;

import java.util.List;

public class Validators {
    public static List<Validator> asList() {
        return List.of(new LengthValidator(), new UppercaseValidator(), new NumberValidator());
    }

    public static Validator getPrimaryValidator() {
        return new LowerCaseValidator();
    }
}
