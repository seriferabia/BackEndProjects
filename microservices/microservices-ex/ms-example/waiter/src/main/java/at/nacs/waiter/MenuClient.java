package at.nacs.waiter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("menu")
public interface MenuClient {

  @GetMapping("/meals")
  List<String> findMeals();
}
