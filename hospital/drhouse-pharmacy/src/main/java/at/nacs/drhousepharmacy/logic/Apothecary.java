package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistence.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("pharmacy")
public class Apothecary {
    @Setter
    @Getter
    private Map<String,String> medicines;

    public Patient giveMedicine(Patient patient){
        String medicine = medicines.getOrDefault(patient.getDiagnosis(),"nutella");
        patient.setMedicine(medicine);
        return patient;
    }
}
