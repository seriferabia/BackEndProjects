package at.nacs.cashier.logic;

import at.nacs.cashier.communication.BaristaClient;
import at.nacs.cashier.communication.PickupClient;
import at.nacs.cashier.persistence.model.Beverage;
import at.nacs.cashier.persistence.model.Purchase;
import at.nacs.cashier.persistence.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class Cashier {
  private final PurchaseRepository purchaseRepository;
  private final Map<String, Double> beveragesMenu;
  private final CashierManager manager;
  private final BaristaClient baristaClient;
  private final PickupClient pickupClient;

  public List<String> displayMenu() {
    return beveragesMenu.entrySet().stream()
                        .map(e -> e.getKey() + ": " + e.getValue() + "€")
                        .collect(toList());
  }

  public Purchase provideTicket(List<String> names) {
    String ticketId = UUID.randomUUID().toString();
    List<Beverage> beverages = manager.toBeverages(names);
    beverages.stream()
             .forEach(e -> e.setTicketId(ticketId));
    Purchase purchase = manager.toPurchase(beverages);
    purchase.setTicketId(ticketId);
    purchaseRepository.save(purchase);
    return purchase;
  }

  public String sendToBarista(Beverage beverage) {
    return baristaClient.status(beverage);
  }

  public String sendToPickup(Purchase purchase) {
    return pickupClient.status(purchase);
  }


}
