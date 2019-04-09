package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class DrHouseTest {

    @Autowired
    DrHouse drHouse;


    @Test
    void testKnownDiagnose() {
        Patient patient = new Patient("1","serife","headache"," ");
        Patient actual = drHouse.diagnose(patient);
        Assertions.assertThat(actual.getDiagnosis()).isEqualTo("migren");
    }

    @Test
    void testUnKnownDiagnose() {
        Patient patient = new Patient("2","hala","backache"," ");
        Patient actual = drHouse.diagnose(patient);
        Assertions.assertThat(actual.getDiagnosis()).isEqualTo("lupus");
    }




}