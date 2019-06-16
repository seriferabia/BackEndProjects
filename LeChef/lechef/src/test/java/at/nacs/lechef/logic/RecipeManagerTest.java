package at.nacs.lechef.logic;

import at.nacs.lechef.logic.recipe.RecipeManager;
import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.Recipe;
import at.nacs.lechef.persistence.repository.RecipeRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("testdata")
class RecipeManagerTest {

  @Autowired
  RecipeManager manager;

  @Autowired
  RecipeRepository repository;

  @Setter
  List<Recipe> recipes;

  @Setter
  Recipe recipe;

  @Setter
  List<Ingredient> testingredients1;

  @Setter
  List<Ingredient> testingredients2;

  @BeforeEach
  void setUp() {
    repository.deleteAll();
    repository.saveAll(recipes);
  }

  @Test
  void findAll() {
    int actualSize = manager.findAll().size();
    assertThat(actualSize).isEqualTo(3);
  }

  @Test
  void save() {
    manager.save(recipe);
    assertThat(recipe.getId()).isNotNull();
  }

  @Test
  void getByType() {
    List<Recipe> actual = manager.getByType("dessert");
    assertThat(actual.get(0).getName()).isEqualTo("tramisu");
    assertThat(actual.get(0).getType()).isEqualTo("dessert");
  }

  @Test
  void getByLabel() {
    List<Recipe> actual = manager.getByLabel(List.of("spicy"));
    assertThat(actual.get(0).getLabels()).contains("spicy");
    assertThat(actual.get(0).getName()).isEqualTo("doner");
  }

  @Test
  void getByOrigin() {
    List<Recipe> actual = manager.getByOrigin("turkey");
    assertThat(actual.get(0).getOrigin()).isEqualTo("turkey");
    assertThat(actual.get(0).getName()).isEqualTo("doner");
  }

  @Test
  void testGetRecipesContainAllIngredients() {
    List<Recipe> recipes = manager.getRecipesContainAllIngredients(testingredients1);
    assertThat(recipes.get(0).getName()).isEqualTo("tzatziki");
  }

  @Test
  void testGetRecipesContainMostOfIngredients() {
    List<Recipe> recipes = manager.getRecipesContainMostOfIngredients(testingredients2);
    assertThat(recipes.get(0).getName()).isEqualTo("tramisu");
  }
}