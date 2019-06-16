package at.nacs.morse.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties("morse-alphabet")
public class Dictionary {

    @Getter
    @Setter
    private Map<String, String> dictionary = new HashMap<>();
}
