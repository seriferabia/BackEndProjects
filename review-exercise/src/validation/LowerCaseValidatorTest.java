package validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowerCaseValidatorTest {

    private Validator validator = new LowerCaseValidator();

    @ParameterizedTest
    @CsvSource({
            "valid case, true",
            "VALiD CASE, true",
            "INVALID, false"
    })
    void testLowerCase(String password, Boolean expected) {
        assertEquals(validator.check(password), expected);
    }
}