package at.nacs.lechef.communication;

import at.nacs.lechef.logic.recipe.RecipeManager;
import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeEndpoint {
  private final RecipeManager manager;

  @GetMapping
  List<Recipe> get() {
    return manager.findAll();
  }

  @PostMapping
  Recipe post(@RequestBody Recipe recipe) {
    return manager.save(recipe);
  }

  @GetMapping("/type/{type}")
  List<Recipe> getByType(@PathVariable String type) {
    return manager.getByType(type);
  }

  @GetMapping("/label/{labels}")
  List<Recipe> getByLabel(@PathVariable List<String> labels) {
    return manager.getByLabel(labels);
  }

  @GetMapping("/origin/{origin}")
  List<Recipe> getByOrigin(@PathVariable String origin) {
    return manager.getByOrigin(origin);
  }

  @GetMapping("/with/all/ingredients")
  List<Recipe> getRecipesContainAllIngredients(@RequestBody List<Ingredient> ingredients) {
    return manager.getRecipesContainAllIngredients(ingredients);
  }

  @GetMapping("/with/most/ingredients")
  List<Recipe> getRecipesContainMostOfIngredients(@RequestBody List<Ingredient> ingredients) {
    return manager.getRecipesContainMostOfIngredients(ingredients);
  }
}
