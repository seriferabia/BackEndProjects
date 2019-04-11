package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Admission {

    public Patient register(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patient;
    }

}
