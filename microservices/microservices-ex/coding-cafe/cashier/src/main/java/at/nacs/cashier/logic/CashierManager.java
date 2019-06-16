package at.nacs.cashier.logic;

import at.nacs.cashier.persistence.model.Beverage;
import at.nacs.cashier.persistence.model.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CashierManager {
  public Purchase toPurchase(List<Beverage> beverages) {
    return Purchase.builder()
                   .beverages(beverages)
                   .build();
  }

  public List<Beverage> toBeverages(List<String> names) {
    return names.stream()
                .map(e->toBeverage(e))
                .collect(Collectors.toList());
  }

  private Beverage toBeverage(String name) {
    return Beverage.builder()
                   .name(name)
                   .build();
  }
}
