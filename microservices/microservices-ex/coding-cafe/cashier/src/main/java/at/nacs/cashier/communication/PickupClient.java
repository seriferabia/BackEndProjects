package at.nacs.cashier.communication;

import at.nacs.cashier.persistence.model.Purchase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("pickup")
public interface PickupClient {

  @PostMapping("/pickup")
  String status(Purchase purchase);
}
