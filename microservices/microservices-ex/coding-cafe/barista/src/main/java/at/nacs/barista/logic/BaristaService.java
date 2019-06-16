package at.nacs.barista.logic;

import at.nacs.barista.communication.PickupClient;
import at.nacs.barista.model.Beverage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BaristaService {
  private final PickupClient pickupClient;
  public String status(Beverage beverage) {
    if (!beverage.getTicketId().isEmpty()) {
      return "OK!";
    }
    return "Invalid order!";
  }

  public String sendToBarista(Beverage beverage){
    Beverage prepared = prepare(beverage);
    return pickupClient.receiveBeverage(prepared);
  }

  private Beverage prepare(Beverage beverage) {
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return Beverage.builder()
                   .name(beverage.getName())
                   .ticketId(beverage.getTicketId())
                   .isReady(true)
                   .build();
  }
}
