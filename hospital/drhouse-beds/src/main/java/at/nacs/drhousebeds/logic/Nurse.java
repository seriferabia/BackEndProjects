package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("medical")
public class Nurse {

    @Getter
    @Setter
    private Map<String, String> treatments;

    public Patient treat(Patient patient){
        String diagnosis = patient.getDiagnosis();
        String treatment = treatments.getOrDefault(diagnosis,"Redirect to the doctor");
        patient.setTreatment(treatment);
        return patient;
    }
}
