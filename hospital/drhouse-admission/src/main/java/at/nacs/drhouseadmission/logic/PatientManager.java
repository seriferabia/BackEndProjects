package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.controller.Admission;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PatientManager {

    private final Admission admission;
    private final RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    private String url;

    public Patient post(Patient patient){
        Patient registeredPatient = admission.register(patient);
        return restTemplate.postForObject(url,registeredPatient,Patient.class);
    }
}
