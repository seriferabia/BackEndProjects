package at.nacs.bew3reflection.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HandshakeMovesTest {
    @Autowired
    HandshakeMoves moves;

    @ParameterizedTest
    @CsvSource({
            "2, Thumb touches back",
            "3, Little finger grab",
            "5, Tickles over palm"
    })
    void getMoves(Integer key, String move) {
        assertEquals(move,moves.getMoves().get(key));
    }
}