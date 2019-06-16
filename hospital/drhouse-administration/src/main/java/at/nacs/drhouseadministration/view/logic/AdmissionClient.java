package at.nacs.drhouseadministration.view.logic;

import at.nacs.drhouseadministration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AdmissionClient {
  private final RestTemplate restTemplate;

  @Value("${admission.url}")
  private String url;

  public Patient post(Patient patient) {
    return restTemplate.postForObject(url, patient, Patient.class);
  }
}
