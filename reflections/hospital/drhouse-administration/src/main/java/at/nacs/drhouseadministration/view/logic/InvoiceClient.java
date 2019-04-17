package at.nacs.drhouseadministration.view.logic;

import at.nacs.drhouseadministration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceClient {
  private final RestTemplate restTemplate;

  @Value("${accountancy.url}")
  private String url;

  public List<Invoice> getInvoices() {
    Invoice[] invoices = restTemplate.getForObject(url, Invoice[].class);
    return new ArrayList<>(Arrays.asList(invoices));
  }

  public void markAsPaid(String id) {
    restTemplate.put(url + "/" + id + "/paid", void.class);
  }
}
