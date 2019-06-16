package at.nacs.drhousepharmacy.communication;


import at.nacs.drhousepharmacy.logic.PharmacyManager;
import at.nacs.drhousepharmacy.persistence.Patient;
import at.nacs.drhousepharmacy.persistence.PharmacyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PharmacyEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    PharmacyManager manager;

    @MockBean
    PharmacyRepository repository;

    private String url = "/patients";


    @Test
    void post() {
        Patient patient = new Patient("1", "patient1", "symptom1", "diagnosis1", null);
        testRestTemplate.postForObject(url,patient,Patient.class);
        verify(manager).post(any());
    }

}