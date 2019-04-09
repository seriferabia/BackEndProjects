package validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UppercaseValidatorTest {
    private Validator validator = new UppercaseValidator();

    @ParameterizedTest
    @CsvSource({
            "invalid case, false",
            "VALID CASE, true",
            "Valid case, true"
    })
    void testUpperCase(String password, Boolean expected) {
        assertEquals(validator.check(password), expected);
    }

}