package at.nacs.pickup.communication;

import at.nacs.pickup.logic.PickupStation;
import at.nacs.pickup.model.Beverage;
import at.nacs.pickup.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pickup")
@RequiredArgsConstructor
public class PickupEndpoint {
  private final PickupStation pickupStation;

  @PostMapping
  String status(@RequestBody Purchase purchase){
    return pickupStation.statusForPurchase(purchase);
  }

  @PostMapping("/beverage")
  String receiveBeverage(@RequestBody Beverage beverage){
    return pickupStation.statusForBeverage(beverage);
  }
}
