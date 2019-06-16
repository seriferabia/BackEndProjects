package at.nacs.pickup.logic;

import at.nacs.pickup.model.Beverage;
import at.nacs.pickup.model.Purchase;
import org.springframework.stereotype.Service;

@Service
public class PickupStation {
  public String statusForPurchase(Purchase purchase) {
    if (!purchase.getTicketId().equals(null)) {
      return "I got Purchase";
    }
    return "This purchase is not valid";
  }

  public String statusForBeverage(Beverage beverage) {
    if (beverage.isReady()) {
      return "Ok! Thanks!";
    }
    return "This beverage is not ready!";
  }

}
