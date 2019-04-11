package at.nacs.morse.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MorseEncoderTest {

    @Autowired
    MorseEncoder encoder;

    @ParameterizedTest
    @CsvSource({
            "a,.-",
            "H,....",
            "t,-",
            "W,.--",
            "0,-----",
            "5,.....",
            "8,---..",
    })
    void translate(String message, String encoded) {
        String actual = encoder.translate(message);
        assertThat(actual).isEqualTo(encoded);

    }
}