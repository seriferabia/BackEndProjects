package at.nacs.cashier.communication;

import at.nacs.cashier.logic.Cashier;
import at.nacs.cashier.persistence.model.Purchase;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("testdata")
class CashierEndpointTest {
  @Autowired
  TestRestTemplate testRestTemplate;

  @MockBean
  Cashier cashier;



  @Test
  void getMenu() {
    testRestTemplate.getForObject("/cashier/display/menu", String[].class);
    verify(cashier).displayMenu();
  }

  @Test
  void provideTicket() {
    testRestTemplate.getForObject("/cashier/take/order/Espresso",Purchase.class);
    verify(cashier).provideTicket(anyList());
  }
}