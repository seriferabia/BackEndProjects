package at.nacs.reaction.communication.dispatcher;

import at.nacs.reaction.communication.dto.Reaction;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ReactionDispatcher {
  private final MessageChannel reactions;
  private Random random = new Random();

  public void sendReaction(String uuid) {
    waitSomeSeconds();
    Reaction reaction = new Reaction(uuid);
    Message<Reaction> message = MessageBuilder.withPayload(reaction)
                                              .build();
    reactions.send(message);
  }

  private void waitSomeSeconds() {
    int waitingTimeInSeconds = random.nextInt(1) + 1;
    int waitingTimeInMilliseconds = waitingTimeInSeconds * 1000;
    try {
      Thread.sleep(waitingTimeInMilliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
