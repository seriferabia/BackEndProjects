package validation;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class LowerCaseValidator implements Validator {
    @Override
    public Boolean check(String password) {
        return Stream.of(password.split(""))
                .anyMatch(isLowerCase());
    }

    private Predicate<String> isLowerCase() {
        return e -> Character.isLowerCase(e.charAt(0));
    }
}
