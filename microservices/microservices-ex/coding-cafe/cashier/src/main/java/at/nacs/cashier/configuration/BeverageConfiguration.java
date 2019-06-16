package at.nacs.cashier.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("coding-cafe")
public class BeverageConfiguration {
  @Getter
  @Setter
  private Map<String,Double> beveragesMenu;

  @Bean
  Map<String,Double> beveragesMenu(){
    return beveragesMenu;
  }

}
