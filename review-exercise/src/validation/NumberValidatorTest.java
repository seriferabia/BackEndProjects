package validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberValidatorTest {
    private Validator validator = new NumberValidator();

    @ParameterizedTest
    @CsvSource({
            "Invalid case, false",
            "VALID CASE1, true",
            "Valid1 case2, true"
    })
    void testNumberValidator(String password, Boolean expected) {
        assertEquals(validator.check(password), expected);
    }
}