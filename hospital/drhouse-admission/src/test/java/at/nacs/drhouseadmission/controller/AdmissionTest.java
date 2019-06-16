package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @Test
    void register() {
        Patient unregisteredPatient = new Patient(null,"serife","headache");
        Patient registeredPatient = admission.register(unregisteredPatient);
        Assertions.assertThat(registeredPatient.getId()).isNotNull();
    }
}