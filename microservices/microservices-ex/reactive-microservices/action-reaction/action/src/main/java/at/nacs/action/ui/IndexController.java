package at.nacs.action.ui;

import at.nacs.action.logic.OperationService;
import at.nacs.action.persistence.domain.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {
  private final OperationService service;

  @ModelAttribute("operations")
  List<Operation> operations() {
    return service.findAll();
  }

  @GetMapping
  String page() {
    return "index";
  }

  @PostMapping
  String post() {
    service.sendAction();
    return "redirect:/";
  }
}
