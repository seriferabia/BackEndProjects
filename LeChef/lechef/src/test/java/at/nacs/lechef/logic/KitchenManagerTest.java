package at.nacs.lechef.logic;

import at.nacs.lechef.logic.user.KitchenManager;
import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.Recipe;
import at.nacs.lechef.persistence.model.User;
import at.nacs.lechef.persistence.repository.RecipeRepository;
import at.nacs.lechef.persistence.repository.UserRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("testdata2")
class KitchenManagerTest {
  @Autowired
  KitchenManager kitchenManager;

  @Autowired
  RecipeRepository recipeRepository;

  @Autowired
  UserRepository repository;

  @Setter
  User user;

  @Setter
  Ingredient ingredient;

  @Setter
  Recipe recipe;

  @BeforeEach
  void setUp() {
    repository.deleteAll();
    repository.save(user);
    recipeRepository.save(recipe);
  }


  @Test
  void getKitchenItems() {
    Long userId = repository.findAll().get(0).getId();
    List<Ingredient> ingredients = kitchenManager.getKitchenItems(userId);
    assertEquals(ingredients.size(), 2);
  }

  @Test
  void saveKitchenItem() {
    Long userId = repository.findAll().get(0).getId();
    assertEquals(kitchenManager.getKitchenItems(userId).size(), 2);

    kitchenManager.saveKitchenItem(userId, ingredient);
    assertEquals(kitchenManager.getKitchenItems(userId).size(), 3);
  }

  @Test
  void deleteKitchenItem() {
    Long userId = repository.findAll().get(0).getId();
    assertEquals(kitchenManager.getKitchenItems(userId).size(), 2);

    Long ingredientId = repository.findAll().get(0).getKitchen().getItems().get(0).getId();
    kitchenManager.deleteKitchenItem(userId, ingredientId);
    assertEquals(kitchenManager.getKitchenItems(userId).size(), 1);
  }

  @Test
  void removeUsedKitchenItems() {
    Long userId = repository.findAll().get(0).getId();
    Long recipeId = recipeRepository.findAll().get(0).getId();
    assertEquals(kitchenManager.getKitchenItems(userId).size(), 2);
    assertEquals(kitchenManager.getKitchenItems(userId).get(1).getAmount(), 250);

    kitchenManager.removeUsedKitchenItems(userId, recipeId);
    assertEquals(kitchenManager.getKitchenItems(userId).size(), 1);
    assertEquals(kitchenManager.getKitchenItems(userId).get(0).getAmount(), 100);
  }
}