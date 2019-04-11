package at.nacs.bew3reflection.configuration;

import at.nacs.bew3reflection.logic.SpecialAgent;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {
    @Bean
    ApplicationRunner shopApplication(SpecialAgent specialAgent) {
        return args -> {
            specialAgent.shakeHand();
        };
    }
}
