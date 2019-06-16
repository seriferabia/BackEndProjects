package at.nacs.lechef.logic.user;

import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.Recipe;
import at.nacs.lechef.persistence.model.User;
import at.nacs.lechef.persistence.repository.RecipeRepository;
import at.nacs.lechef.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KitchenManager {
  private final UserRepository userRepository;
  private final RecipeRepository recipeRepository;

  public List<Ingredient> getKitchenItems(Long userId) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return new ArrayList<>();
    }
    return oUser.get().getKitchen().getItems();
  }

  public void saveKitchenItem(Long userId, Ingredient item) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return;
    }
    User user = oUser.get();
    user.getKitchen().getItems().add(item);
    userRepository.save(user);
  }

  public void deleteKitchenItem(Long userId, Long itemId) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return;
    }
    User user = oUser.get();
    user.getKitchen().getItems().removeIf(item -> item.getId().equals(itemId));
    userRepository.save(user);
  }

  public void removeUsedKitchenItems(Long userId, Long recipeId) {
    Optional<Recipe> oRecipe = recipeRepository.findById(recipeId);
    if (oRecipe.isEmpty()) {
      return;
    }
    Recipe recipe = oRecipe.get();
    recipe.getIngredients().stream()
          .forEach(ingredient -> updateUsedItem(userId, ingredient));
  }

  private void updateUsedItem(Long userId, Ingredient ingredient) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return;
    }
    User user = oUser.get();
    List<Ingredient> userItems = user.getKitchen().getItems();
    Ingredient item = userItems.stream()
                               .filter(e -> e.getName().equals(ingredient.getName()))
                               .findFirst().orElseThrow();
    if (item.getAmount() == ingredient.getAmount()) {
      deleteKitchenItem(userId, item.getId());
    }
    double newAmount = item.getAmount() - ingredient.getAmount();
    item.setAmount(newAmount);
    userRepository.save(user);
  }
}
