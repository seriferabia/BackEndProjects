package at.nacs.encoder.logic;

import at.nacs.encoder.communication.MorseClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class Encoder {
   private final MorseClient morseClient;

    public String encode(String message) {
        return Stream.of(message.split(""))
                .filter(letter -> !letter.equals(" "))
                .map(letter -> morseClient.encode(letter))
                .collect(Collectors.joining());
    }
}
