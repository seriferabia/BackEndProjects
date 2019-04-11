package at.nacs.bew3reflection.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("handshake")
public class HandshakeMoves {

    @Getter
    @Setter
    private Map<Integer, String> moves;
}
