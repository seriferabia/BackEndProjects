package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Kind;
import at.nacs.drhouseaccountancy.persistence.Patient;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class PatientManager {
    public Patient getPatient(PatientDTO patientDTO) {
        return new Patient(null, patientDTO.getId(), patientDTO.getName());
    }

    public Kind getKind(PatientDTO patientDTO) {
        if (Objects.nonNull(patientDTO.getMedicine())) {
            return Kind.MEDICINE;
        }
        return Kind.TREATMENT;
    }

    public String getProvided(PatientDTO patientDTO) {
        if (Objects.nonNull(patientDTO.getMedicine())) {
            return patientDTO.getMedicine();
        }
        return patientDTO.getTreatment();
    }
}
