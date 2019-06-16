package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("data")
class AccountantTest {

    @SpyBean
    Accountant accountant;

    @MockBean
    PatientRepository patientRepository;

    @MockBean
    InvoiceRepository invoiceRepository;

    @Setter
    @Getter
    private PatientDTO patientWithMedicine;

    @Test
    void testPost(){
        accountant.save(patientWithMedicine);
        Mockito.verify(accountant).save(Mockito.any());

    }


}