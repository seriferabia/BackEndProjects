package at.nacs.waiter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealsEndpoint {
  private final MenuClient menuClient;

  @GetMapping
  List<String> findMeals(){
    return menuClient.findMeals();
  }
}
