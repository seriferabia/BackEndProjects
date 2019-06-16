package at.nacs.lechef.logic.recipe;

import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.Recipe;
import at.nacs.lechef.persistence.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class RecipeManager {
  private final RecipeRepository repository;
  private final RecipeIngredientChecker checker;

  public List<Recipe> findAll() {
    return repository.findAll();
  }

  public Recipe save(Recipe recipe) {
    return repository.save(recipe);
  }

  public List<Recipe> getByType(String type) {
    return repository.findAllByType(type);
  }

  public List<Recipe> getByLabel(List<String> labels) {
    return repository.findAllByLabelsContains(labels);
  }

  public List<Recipe> getByOrigin(String origin) {
    return repository.findAllByOrigin(origin);
  }

  public List<Recipe> getRecipesContainAllIngredients(List<Ingredient> ingredients) {
    List<Recipe> recipes = repository.findAll();
    return recipes.stream()
                  .filter(recipe -> checker.hasAllIngredients(recipe, ingredients))
                  .collect(toList());
  }

  public List<Recipe> getRecipesContainMostOfIngredients(List<Ingredient> ingredients) {
    List<Recipe> recipes = repository.findAll();
    return recipes.stream()
                  .filter(recipe -> checker.hasMostOfIngredients(recipe, ingredients))
                  .collect(toList());
  }
}
