package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistence.Patient;
import at.nacs.drhousebeds.logic.TreatmentManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {
    private final TreatmentManager manager;

    @PostMapping
    Patient post(@RequestBody Patient patient){
        return manager.post(patient);
    }
}
