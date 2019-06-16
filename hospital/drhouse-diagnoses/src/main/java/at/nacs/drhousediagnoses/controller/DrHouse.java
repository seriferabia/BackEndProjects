package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("medical")
public class DrHouse {
    @Getter
    @Setter
    private Map<String,String> diagnosis;

    public Patient diagnose(Patient patient){
        String symptoms = patient.getSymptoms();
        String diagnose = diagnosis.getOrDefault(symptoms,"lupus");
        patient.setDiagnosis(diagnose);
        System.out.println(diagnose);
        return patient;
    }
}
