package at.nacs.action.logic;

import at.nacs.action.communication.dto.Action;
import at.nacs.action.communication.dto.Reaction;
import at.nacs.action.configuration.Binding;
import at.nacs.action.persistence.domain.Operation;
import at.nacs.action.persistence.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OperationService {
  private final OperationRepository repository;
  private final MessageChannel actions;

  public List<Operation> findAll() {
    return repository.findAll();
  }

  public void sendAction() {
    Operation operation = createNewOperation();
    repository.save(operation);

    Action action = new Action(operation.getUuid());
    Message<Action> message = MessageBuilder.withPayload(action)
                                            .build();
    actions.send(message);
  }

  private Operation createNewOperation() {
    return Operation.builder()
                    .uuid(UUID.randomUUID().toString())
                    .action(LocalTime.now())
                    .build();
  }

  @StreamListener(Binding.REACTIONS)
  public void getReaction(Reaction reaction) {
    String uuid = reaction.getUuid();
    Optional<Operation> oOperation = repository.findByUuid(uuid);
    if (oOperation.isEmpty()) {
      return;
    }
    Operation operation = oOperation.get();
    operation.setReaction(LocalTime.now());
    repository.save(operation);
  }
}
