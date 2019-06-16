package at.nacs.polo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class SenderAndReceiver {

  @StreamListener(Processor.INPUT)
  @SendTo(Processor.OUTPUT)
  public String hearMarcoAndSayPolo(String message) {
    System.out.println("<-- MESSAGE RECEIVED: " + message);
    String response = message.replaceAll("Marco", "Polo");
    System.out.println("--> MESSAGE SENT: " + response);
    return response;
  }
}
