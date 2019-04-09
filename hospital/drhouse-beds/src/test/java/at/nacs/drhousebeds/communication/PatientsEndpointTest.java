package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.TreatmentManager;
import at.nacs.drhousebeds.persistence.BedsRepository;
import at.nacs.drhousebeds.persistence.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    TreatmentManager manager;

    @MockBean
    BedsRepository repository;

    private String url = "/patients";


    @Test
    void post() {
        Patient patient = new Patient("1", "patient1", "symptom1", "diagnosis1", null);
        testRestTemplate.postForObject(url,patient,Patient.class);
        verify(manager).post(any());
    }
}