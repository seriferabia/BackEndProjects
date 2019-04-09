package validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthValidatorTest {
    private Validator validator = new LengthValidator();

    @ParameterizedTest
    @CsvSource({
            "valid length, true",
            "notValid, false"
    })
    void testLength(String password, Boolean expected) {
        assertEquals(validator.check(password), expected);
    }
}