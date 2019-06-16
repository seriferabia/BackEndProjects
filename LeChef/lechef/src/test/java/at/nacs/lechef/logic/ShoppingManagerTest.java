package at.nacs.lechef.logic;

import at.nacs.lechef.logic.user.ShoppingManager;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("testdata2")
class ShoppingManagerTest {

  @Autowired
  ShoppingManager shoppingManager;

  @Autowired
  RecipeRepository recipeRepository;

  @Autowired
  UserRepository repository;

  @Setter
  User user;

  @Setter
  Recipe recipe2;

  @BeforeEach
  void setUp() {
    repository.deleteAll();
    repository.save(user);
    recipeRepository.save(recipe2);
  }

  @Test
  void getShoppingList() {
    Long userId = repository.findAll().get(0).getId();
    List<Ingredient> shoppingList = shoppingManager.getShoppingList(userId);
    assertTrue(shoppingList.isEmpty());
  }

  @Test
  void updateShoppingList() {
    Long userId = repository.findAll().get(0).getId();
    Long recipeId = recipeRepository.findAll().get(0).getId();
    assertTrue(shoppingManager.getShoppingList(userId).isEmpty());

    shoppingManager.updateShoppingList(userId, recipeId);
    assertEquals(shoppingManager.getShoppingList(userId).size(), 2);
    assertEquals(shoppingManager.getShoppingList(userId).get(0).getName(), "meat");
  }

  @Test
  void markAsBought() {
    Long userId = repository.findAll().get(0).getId();
    Long recipeId = recipeRepository.findAll().get(0).getId();
    shoppingManager.updateShoppingList(userId, recipeId);
    Ingredient necessity = shoppingManager.getShoppingList(userId).get(0);
    assertFalse(necessity.isBought());

    shoppingManager.markAsBought(userId, necessity.getId());
    assertFalse(shoppingManager.getShoppingList(userId).contains(necessity));
  }
}