package logic;

import validation.Validator;
import validation.Validators;

import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

public class Verifier {
    private final Integer NUMBER_OF_NECESSARY_VALIDATIONS = 1;
    private List<Validator> validators = Validators.asList();

    public Boolean isOkay(String password) {
        if (isNotOkayForCheck(password)) {
            return false;
        }
        return validators.stream()
                .filter(isValid(password))
                .count() >= NUMBER_OF_NECESSARY_VALIDATIONS;
    }

    private boolean isNotOkayForCheck(String password) {
        return isNull(password) || isNotOkay(password);
    }

    private Boolean isNotOkay(String password) {
        Validator validator = Validators.getPrimaryValidator();
        return !validator.check(password);
    }

    private Predicate<Validator> isValid(String password) {
        return validator -> validator.check(password).equals(true);
    }
}
