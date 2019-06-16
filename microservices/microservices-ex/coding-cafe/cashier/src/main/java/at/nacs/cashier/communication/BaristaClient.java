package at.nacs.cashier.communication;

import at.nacs.cashier.persistence.model.Beverage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("barista")
public interface BaristaClient {

  @PostMapping("/barista")
  String status(Beverage beverage);
}
