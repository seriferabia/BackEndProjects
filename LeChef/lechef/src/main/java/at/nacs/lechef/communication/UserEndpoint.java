package at.nacs.lechef.communication;

import at.nacs.lechef.logic.user.KitchenManager;
import at.nacs.lechef.logic.user.ShoppingManager;
import at.nacs.lechef.logic.user.UserManager;
import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserEndpoint {
  private final UserManager userManager;
  private final KitchenManager kitchenManager;
  private final ShoppingManager shoppingManager;

  @PostMapping
  User save(@RequestBody User user) {
    return userManager.save(user);
  }

  @GetMapping("/id/{userId}/kitchen")
  List<Ingredient> getKitchen(@PathVariable Long userId) {
    return kitchenManager.getKitchenItems(userId);
  }

  @PutMapping("/id/{userId}")
  void saveIngredient(@PathVariable Long userId, @RequestBody Ingredient ingredient) {
    kitchenManager.saveKitchenItem(userId, ingredient);
  }

  @DeleteMapping("/id/{userId}/ingredient/{ingredientId}")
  void deleteIngredient(@PathVariable Long userId, @PathVariable Long ingredientId) {
    kitchenManager.deleteKitchenItem(userId, ingredientId);
  }

  @PutMapping("/id/{userId}/cooked/recipe/{recipeId}")
  void updateKitchenItems(@PathVariable Long userId, @PathVariable Long recipeId) {
    kitchenManager.removeUsedKitchenItems(userId, recipeId);
  }

  @GetMapping("/id/{userId}/shoppinglist")
  List<Ingredient> getShoppingList(@PathVariable Long userId) {
    return shoppingManager.getShoppingList(userId);
  }

  @PutMapping("/id/{userId}/selected/recipe/{recipeId}")
  void updateShoppingList(@PathVariable Long userId, @PathVariable Long recipeId) {
    shoppingManager.updateShoppingList(userId, recipeId);
  }

  @PutMapping("/id/{userId}/necessity/{necessityId}")
  void markAsBought(@PathVariable Long userId, @PathVariable Long necessityId) {
    shoppingManager.markAsBought(userId, necessityId);
  }
}
