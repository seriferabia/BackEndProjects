package at.nacs.morse.logic;

import at.nacs.morse.persistence.Dictionary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MorseEncoder {
    private final Dictionary dictionary;

    public String translate(String letter) {
        String encodedLetter = dictionary.getDictionary().get(letter.toUpperCase());
        return encodedLetter;
    }
}

