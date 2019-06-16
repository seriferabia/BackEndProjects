package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@ConfigurationProperties("medical")
@RequiredArgsConstructor
public class PriceManager {
    private final PatientManager patientManager;
    @Setter
    @Getter
    private Map<String, Double> prices;

    public Double calculatePrice(PatientDTO patientDTO) {
        String provided = patientManager.getProvided(patientDTO);
        return prices.getOrDefault(provided, 50.0);
    }

}
