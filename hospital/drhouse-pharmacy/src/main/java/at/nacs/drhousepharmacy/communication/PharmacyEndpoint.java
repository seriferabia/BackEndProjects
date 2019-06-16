package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.logic.PharmacyManager;
import at.nacs.drhousepharmacy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PharmacyEndpoint {
    private final PharmacyManager manager;

    @PostMapping
    Patient post(@RequestBody Patient patient){
        return manager.post(patient);
    }
}
