package validation;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class UppercaseValidator implements Validator {
    @Override
    public Boolean check(String password) {
        return Stream.of(password.split(""))
                .anyMatch(isUpperCase());
    }

    private Predicate<String> isUpperCase() {
        return e -> Character.isUpperCase(e.charAt(0));
    }
}
