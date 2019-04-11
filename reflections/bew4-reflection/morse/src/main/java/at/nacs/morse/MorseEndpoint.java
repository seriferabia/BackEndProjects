package at.nacs.morse;

import at.nacs.morse.controller.MorseEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseEndpoint {
    private final MorseEncoder translator;

    @PostMapping
    String encode(@RequestBody String letter) {
        return translator.translate(letter);
    }

}
