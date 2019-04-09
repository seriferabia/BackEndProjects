package verification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordVerifierTest {

    private PasswordVerifier verifier = new PasswordVerifier();

    @ParameterizedTest
    @CsvSource({
            "StrongPassword123, true",
            "NotStrongButOkay, true ",
            "okay password2, true",
            "Okay3, true",
            "NOT OKAY, false",
            "ok?, false",
            "not ok!, false",
            ",false"

    })
    void testVerify(String password, Boolean expected) {
        assertEquals(verifier.verify(password), expected);
    }

    @Test
    void testNullCase() {
        assertEquals(verifier.verify(null), false);
    }

}