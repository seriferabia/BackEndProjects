package at.nacs.morse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MorseEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/morse";

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
    void encode(String message, String expected) {
        String actual = testRestTemplate.postForObject(url, message, String.class);
        assertThat(actual).isEqualTo(expected);
    }
}