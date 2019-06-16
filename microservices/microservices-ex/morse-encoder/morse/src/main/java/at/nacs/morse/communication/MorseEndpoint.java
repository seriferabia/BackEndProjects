package at.nacs.morse.communication;

import at.nacs.morse.logic.MorseEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
@RefreshScope
public class MorseEndpoint {
    private final MorseEncoder translator;

    @PostMapping
    String encode(@RequestBody String letter) {
        return translator.translate(letter);
    }

}
