package at.nacs.encoder;

import at.nacs.encoder.controller.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncoderEndpoint {

    private final Encoder encoder;

    @Value("${morse.url}")
    private String url;

    @PostMapping
    String getEncodedMessage(@RequestBody String message) {
        return encoder.encode(message, url);
    }
}

