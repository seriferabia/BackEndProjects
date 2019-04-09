package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.domain.Patient;
import at.nacs.drhousediagnoses.logic.DiagnoseManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {
    private final DiagnoseManager diagnoseManager;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return diagnoseManager.redirectPatient(patient);
    }
}
