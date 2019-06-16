package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.Patient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class NurseTest {

    @Autowired
    Nurse nurse;

    @ParameterizedTest
    @CsvSource({
            "1,patient1,symptom1,tumor,chemotherapy",
            "2,patient2,symptom2,lupus,operation",
            "3,patient3,symptom3,unknown,Redirect to the doctor"
    })
    void testTreat(String id, String name, String symptom, String diagnoses, String expected) {
        Patient patient = new Patient(id, name, symptom, diagnoses, null);
        Patient actual = nurse.treat(patient);
        assertThat(actual.getTreatment()).isEqualTo(expected);

    }
}