package at.nacs.action.configuration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Binding {

  String ACTIONS = "actions";
  String REACTIONS = "reactions";

  @Output(ACTIONS)
  MessageChannel actions();

  @Input(REACTIONS)
  SubscribableChannel reactions();

}
