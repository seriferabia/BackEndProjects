package at.nacs.marco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MarcoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MarcoApplication.class, args);
  }

}
