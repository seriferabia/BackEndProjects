package at.nacs.bew3reflection.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HandshakeTranslatorTest {

    @Autowired
    HandshakeTranslator translator;

    @Test
    void testTranslateToMoves() {
        List<String> expected = Arrays.asList("Thumb touches back", "Little finger grab", "Tickles over palm");
        List<String> moves = translator.translateToMoves(235);
        assertEquals(expected, moves);
    }

    @Test
    void testNonexclusiveDigits() {
        List<String> expected = Arrays.asList("Thumb touches back", "Tickles over palm");
        List<String> moves = translator.translateToMoves(215);
        assertEquals(expected, moves);

        expected = new ArrayList<>();
        moves = translator.translateToMoves(178);
        assertEquals(expected, moves);
    }
}