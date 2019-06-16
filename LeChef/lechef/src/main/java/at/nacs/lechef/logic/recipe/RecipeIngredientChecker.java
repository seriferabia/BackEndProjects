package at.nacs.lechef.logic.recipe;

import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientChecker {
  public boolean hasAllIngredients(Recipe recipe, List<Ingredient> ingredients) {
    if (recipe.getIngredients().size() > ingredients.size()) {
      return false;
    }
    return ingredients.stream()
                      .allMatch(ingredient -> isIn(ingredient, recipe.getIngredients()));
  }

  public boolean hasMostOfIngredients(Recipe recipe, List<Ingredient> ingredients) {
    if (recipe.getIngredients().size() - ingredients.size() > 2) {
      return false;
    }
    long numberOfMatchedIngredients = ingredients.stream()
                                                 .filter(ingredient -> isIn(ingredient, recipe.getIngredients()))
                                                 .count();
    return numberOfMatchedIngredients > 0 && numberOfMatchedIngredients > recipe.getIngredients().size() - 3;
  }

  private boolean isIn(Ingredient ingredient, List<Ingredient> ingredients) {
    return ingredients.stream().anyMatch(e -> e.equals(ingredient));
  }
}
