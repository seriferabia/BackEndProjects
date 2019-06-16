package at.nacs.lechef.persistence.repository;

import at.nacs.lechef.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
