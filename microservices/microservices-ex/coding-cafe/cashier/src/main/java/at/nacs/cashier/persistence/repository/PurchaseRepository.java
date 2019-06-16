package at.nacs.cashier.persistence.repository;

import at.nacs.cashier.persistence.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
  Purchase findByTicketId(String ticketId);
}
