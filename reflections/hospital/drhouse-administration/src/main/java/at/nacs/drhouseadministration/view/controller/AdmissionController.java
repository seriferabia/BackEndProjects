package at.nacs.drhouseadministration.view.controller;

import at.nacs.drhouseadministration.view.logic.AdmissionClient;
import at.nacs.drhouseadministration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AdmissionController {
  private final AdmissionClient client;

  @ModelAttribute("patient")
  Patient patient() {
    return new Patient();
  }

  @GetMapping
  String page() {
    return "home";
  }

  @PostMapping
  String post(Patient patient, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    client.post(patient);
    return "redirect:/";
  }
}
