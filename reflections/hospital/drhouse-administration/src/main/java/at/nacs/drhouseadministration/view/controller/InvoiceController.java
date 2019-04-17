package at.nacs.drhouseadministration.view.controller;

import at.nacs.drhouseadministration.view.logic.InvoiceClient;
import at.nacs.drhouseadministration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
  private final InvoiceClient client;

  @ModelAttribute("invoice")
  Invoice invoice() {
    return new Invoice();
  }

  @ModelAttribute("invoices")
  List<Invoice> invoices() {
    return client.getInvoices();
  }

  @GetMapping
  String page() {
    return "invoice";
  }

  @PostMapping("/paid")
  String post(@RequestParam String id) {
    client.markAsPaid(id);
    return "redirect:/invoices";
  }
}
