package at.nacs.barista.communication;

import at.nacs.barista.logic.BaristaService;
import at.nacs.barista.model.Beverage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barista")
@RequiredArgsConstructor
public class BaristaEndpoint {
  private final BaristaService baristaService;

  @PostMapping
  String status(@RequestBody Beverage beverage) {
    return baristaService.status(beverage);
  }

  @PostMapping("/pickup")
  String sendToPickup(@RequestBody Beverage beverage) {
    return baristaService.sendToBarista(beverage);
  }
}
