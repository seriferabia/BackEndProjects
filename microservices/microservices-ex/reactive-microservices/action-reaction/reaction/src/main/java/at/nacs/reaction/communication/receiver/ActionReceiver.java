package at.nacs.reaction.communication.receiver;

import at.nacs.reaction.communication.dispatcher.ReactionDispatcher;
import at.nacs.reaction.communication.dto.Action;
import at.nacs.reaction.configuration.Binding;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionReceiver {
  private final ReactionDispatcher dispatcher;

  @StreamListener(Binding.ACTIONS)
  public void listenActionAndReact(Action action){
    dispatcher.sendReaction(action.getUuid());
  }
}
