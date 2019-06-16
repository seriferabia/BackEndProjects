package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.controller.DrHouse;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@ConfigurationProperties("direction")
@RequiredArgsConstructor
public class DiagnoseManager {

    private final RestTemplate restTemplate;
    private final DrHouse drHouse;

    @Setter
    @Getter
    private Map<String,String> units;

    @Value("${beds.url}")
    private String bedsUrl;

    @Value("${pharmacy.url}")
    private String pharmacyUrl;

    public Patient redirectPatient(Patient patient){
        Patient diagnosedPatient = drHouse.diagnose(patient);
        String unit = units.get(diagnosedPatient.getDiagnosis());
        if(unit.equals("beds")){
            return restTemplate.postForObject(bedsUrl,patient,Patient.class);
        }
        return restTemplate.postForObject(pharmacyUrl,patient,Patient.class);
    }

}


