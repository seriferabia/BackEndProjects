package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistence.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ApothecaryTest {

    @Autowired
    Apothecary apothecary;

    @ParameterizedTest
    @CsvSource({
            "1,patient1,symptom1,migren,naproxen",
            "2,patient2,symptom2,reflux,gaviscon",
            "3,patient3,symptom2,unknown,nutella"
    })
    void giveMedicine(String id, String name, String symptom, String diagnoses, String expected) {
        Patient patient = new Patient(id, name, symptom, diagnoses, null);
        Patient actual = apothecary.giveMedicine(patient);
        assertThat(actual.getMedicine()).isEqualTo(expected);
    }
}