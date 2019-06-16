package at.nacs.cashier.communication;

import at.nacs.cashier.logic.Cashier;
import at.nacs.cashier.persistence.model.Beverage;
import at.nacs.cashier.persistence.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashier")
@RequiredArgsConstructor
@RefreshScope
public class CashierEndpoint {
  private final Cashier cashier;

  @GetMapping("/display/menu")
  List<String> getMenu() {
    return cashier.displayMenu();
  }

  @GetMapping("/take/order/{names}")
  Purchase provideTicket(@PathVariable List<String> names) {
    return cashier.provideTicket(names);
  }

  @PostMapping("/barista")
  String sendToBarista(@RequestBody Beverage beverage) {
    return cashier.sendToBarista(beverage);
  }

  @PostMapping("/pickup")
  String sendToPickup(@RequestBody Purchase purchase) {
    return cashier.sendToPickup(purchase);
  }

}
