package at.nacs.lechef.communication;

import at.nacs.lechef.logic.user.KitchenManager;
import at.nacs.lechef.logic.user.ShoppingManager;
import at.nacs.lechef.logic.user.UserManager;
import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.User;
import at.nacs.lechef.persistence.repository.UserRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("testdata2")
class UserEndpointTest {
  @Autowired
  TestRestTemplate testRestTemplate;

  @MockBean
  UserRepository userRepository;

  @SpyBean
  UserManager usermanager;

  @SpyBean
  KitchenManager kitchenManager;

  @SpyBean
  ShoppingManager shoppingManager;
  @Setter
  User user;
  @Setter
  Ingredient ingredient;
  private String url = "/user";

  @Test
  void save() {
    testRestTemplate.postForObject(url, user, User.class);
    verify(usermanager).save(any());
  }

  @Test
  void getItems() {
    String urlOfIngredients = url + "/id/1/kitchen";
    testRestTemplate.getForObject(urlOfIngredients, Ingredient[].class);
    verify(kitchenManager).getKitchenItems(anyLong());
  }

  @Test
  void saveIngredient() {
    testRestTemplate.put(url + "/id/1", void.class);
    verify(kitchenManager).saveKitchenItem(anyLong(), any());
  }

  @Test
  void deleteIngredient() {
    String deleteUrl = url + "/id/1/ingredient/2";
    testRestTemplate.delete(deleteUrl);
    verify(kitchenManager).deleteKitchenItem(anyLong(), anyLong());
  }

  @Test
  void updateKitchenItems() {
    testRestTemplate.put(url + "/id/1/cooked/recipe/2", void.class);
    verify(kitchenManager).removeUsedKitchenItems(anyLong(), anyLong());
  }

  @Test
  void updateShoppingList() {
    testRestTemplate.put(url + "/id/1/selected/recipe/2", void.class);
    verify(shoppingManager).updateShoppingList(anyLong(), anyLong());
  }

  @Test
  void getShoppingList() {
    testRestTemplate.getForObject(url + "/id/1/shoppinglist", Ingredient[].class);
    verify(shoppingManager).getShoppingList(anyLong());
  }

  @Test
  void markAsBought() {
    testRestTemplate.put(url + "/id/1/necessity/2", void.class);
    verify(shoppingManager).markAsBought(anyLong(), anyLong());
  }
}