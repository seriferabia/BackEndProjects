package at.nacs.bew2reflection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimesTest {

    @Autowired
    Primes primes;

    @ParameterizedTest
    @CsvSource({
            "false, 1",
            "true, 2",
            "false, 4",
            "false, 6",
            "true, 5",
            "true, 11",
            "false, 20",
            "true, 37",
            "false, 100"
    })
    void testIsPrime(boolean expected, Integer number) {
        boolean result = primes.isPrime(number);
        assertEquals(expected, result);
    }

}