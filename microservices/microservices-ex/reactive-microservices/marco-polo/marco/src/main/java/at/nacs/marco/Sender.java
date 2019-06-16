package at.nacs.marco;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Sender {
  private final Processor processor;
  private int messageNumber = 0;


  @Scheduled(fixedRate = 5 * 1000)
  public void sendMarcoEveryFiveSeconds() {
    String text = "Marco " + messageNumber;
    Message<String> message = MessageBuilder.withPayload(text)
                                            .build();
    processor.output().send(message);
    System.out.println("--> MESSAGE SENT: " + text);
    messageNumber++;
  }
}
