package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistence.Patient;
import at.nacs.drhousepharmacy.persistence.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PharmacyManager {
    private final Apothecary apothecary;
    private final PharmacyRepository repository;
    private final RestTemplate restTemplate;

    @Value("${accountancy.url}")
    private String url;

    public Patient post(Patient patient){
        Patient patientWithMedicine = apothecary.giveMedicine(patient);
        repository.save(patientWithMedicine);
        return restTemplate.postForObject(url,patientWithMedicine,Patient.class);
    }
}
