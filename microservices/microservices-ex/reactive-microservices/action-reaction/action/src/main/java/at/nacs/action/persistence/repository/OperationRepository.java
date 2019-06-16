package at.nacs.action.persistence.repository;

import at.nacs.action.persistence.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Long> {
  Optional<Operation> findByUuid(String uuid);
}
