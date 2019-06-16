package at.nacs.menu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meals")
@RefreshScope
public class MealsEndpoint {
  @Value("${menu.meals}")
  private List<String> meals;

  @GetMapping
  List<String> get() {
    return meals;
  }
}
