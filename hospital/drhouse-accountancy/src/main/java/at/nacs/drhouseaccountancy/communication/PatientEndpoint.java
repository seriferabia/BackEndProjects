package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {
    private final Accountant accountant;

    @PostMapping
    PatientDTO post(@RequestBody PatientDTO patientDTO) {
        return accountant.save(patientDTO);
    }

}
