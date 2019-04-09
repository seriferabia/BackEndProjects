package at.nacs.drhouseadmission;

import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    private String url = "/patients";

    

    @Test
    void post() {
        Patient patient = new Patient(null,"serife","headache");
        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);
        assertThat(actual.getId()).isNotBlank();
    }
}