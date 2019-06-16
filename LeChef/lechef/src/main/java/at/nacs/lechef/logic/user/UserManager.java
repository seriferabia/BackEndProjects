package at.nacs.lechef.logic.user;

import at.nacs.lechef.persistence.model.User;
import at.nacs.lechef.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager {
  private final UserRepository userRepository;

  public User save(User user) {
    return userRepository.save(user);
  }
}
