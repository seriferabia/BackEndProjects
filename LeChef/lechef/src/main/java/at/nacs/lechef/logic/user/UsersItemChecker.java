package at.nacs.lechef.logic.user;

import at.nacs.lechef.persistence.model.Ingredient;
import at.nacs.lechef.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersItemChecker {

  public void addToShoppingList(User user, Ingredient ingredient) {
    if (!hasAny(user, ingredient)) {
      user.getShoppingList().getNecessities().add(ingredient);
    }
    user.getKitchen().getItems().stream()
        .filter(e -> Objects.equals(e.getName(), ingredient.getName()) && e.getAmount() < ingredient.getAmount())
        .forEach(e -> user.getShoppingList().getNecessities().add(toNecessity(e, ingredient)));
  }

  private Ingredient toNecessity(Ingredient item, Ingredient ingredient) {
    double amount = ingredient.getAmount() - item.getAmount();
    return Ingredient.builder()
                     .name(item.getName())
                     .amount(amount)
                     .unit(item.getUnit())
                     .bought(false)
                     .build();
  }

  private boolean hasAny(User user, Ingredient ingredient) {
    return user.getKitchen().getItems().stream()
               .filter(item -> item.getName().equals(ingredient.getName()))
               .count() > 0;
  }
}