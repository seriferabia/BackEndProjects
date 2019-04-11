package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.BedsRepository;
import at.nacs.drhousebeds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TreatmentManager {
    private final Nurse nurse;
    private final BedsRepository repository;
    private final RestTemplate restTemplate;

    @Value("${accountancy.url}")
    String url;


    public Patient post(Patient patient) {
        Patient treatedPatient = nurse.treat(patient);
        repository.save(treatedPatient);
        return restTemplate.postForObject(url, treatedPatient, Patient.class);
    }
}
