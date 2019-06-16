package at.nacs.barista.communication;

import at.nacs.barista.model.Beverage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("pickup")
public interface PickupClient {

  @PostMapping("/pickup/beverage")
  String receiveBeverage(Beverage beverage);
}
