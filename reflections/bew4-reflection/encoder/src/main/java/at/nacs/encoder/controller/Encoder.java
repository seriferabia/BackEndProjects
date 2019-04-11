package at.nacs.encoder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class Encoder {
    private final RestTemplate restTemplate;

    public String encode(String message, String url) {
        return Stream.of(message.split(""))
                .filter(letter -> !letter.equals(" "))
                .map(letter -> restTemplate.postForObject(url, letter, String.class))
                .collect(Collectors.joining());
    }
}
