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
public class ShoppingManager {
  private final UserRepository userRepository;
  private final RecipeRepository recipeRepository;
  private final UsersItemChecker checker;

  public void updateShoppingList(Long userId, Long recipeId) {
    Optional<Recipe> oRecipe = recipeRepository.findById(recipeId);
    Optional<User> oUser = userRepository.findById(userId);
    if (oRecipe.isEmpty() || oUser.isEmpty()) {
      return;
    }
    Recipe recipe = oRecipe.get();
    User user = oUser.get();
    recipe.getIngredients().stream()
          .forEach(ingredient -> checker.addToShoppingList(user, ingredient));
    userRepository.save(user);
  }

  public List<Ingredient> getShoppingList(Long userId) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return new ArrayList<>();
    }
    return oUser.get().getShoppingList().getNecessities();
  }

  public void markAsBought(Long userId, Long necessityId) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return;
    }
    User user = oUser.get();
    user.getShoppingList().getNecessities().stream()
        .filter(e -> e.getId().equals(necessityId))
        .forEach(necessity -> {
          necessity.setBought(true);
          user.getKitchen().getItems().add(necessity);
          user.getShoppingList().getNecessities().remove(necessity);
          userRepository.save(user);
        });
  }
}
