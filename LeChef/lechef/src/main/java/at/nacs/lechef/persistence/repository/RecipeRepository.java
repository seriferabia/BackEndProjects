package at.nacs.lechef.persistence.repository;

import at.nacs.lechef.persistence.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  List<Recipe> findAllByType(String type);

  List<Recipe> findAllByOrigin(String origin);

  List<Recipe> findAllByLabelsContains(List<String> labels);

}
