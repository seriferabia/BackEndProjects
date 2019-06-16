package at.nacs.cashier.logic;

import at.nacs.cashier.persistence.model.Purchase;
import at.nacs.cashier.persistence.repository.PurchaseRepository;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("testdata")
class CashierTest {
  @Autowired
  Cashier cashier;

  @Autowired
  PurchaseRepository purchaseRepository;

  @Setter
  List<String> names;

  @AfterEach
  void setUp() {
    purchaseRepository.deleteAll();
  }


  @Test
  void testDisplayMenu() {
    List<String> products = cashier.displayMenu();
    assertEquals(products.size(), 11);
  }

  @Test
  void testProvideTicket() {
    Purchase purchase = cashier.provideTicket(names);
    assertNotNull(purchase.getId());
    assertNotNull(purchase.getTicketId());
    assertNotNull(purchase.getBeverages());
    assertNotNull(purchase.getBeverages().get(0).getTicketId());

  }
}