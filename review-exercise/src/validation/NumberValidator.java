package validation;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class NumberValidator implements Validator {
    @Override
    public Boolean check(String password) {
        return Stream.of(password.split(""))
                .anyMatch(hasContainNumber());
    }

    private Predicate<String> hasContainNumber() {
        return e -> Character.isDigit(e.charAt(0));
    }
}

