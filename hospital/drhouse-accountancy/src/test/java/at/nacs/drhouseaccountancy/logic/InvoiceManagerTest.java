package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.Kind;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("data")
class InvoiceManagerTest {

    @Autowired
    InvoiceManager manager;

    @Autowired
    Accountant accountant;

    @Autowired
    InvoiceRepository invoiceRepository;


    @Setter
    @Getter
    private PatientDTO patientWithMedicine;

    @Setter
    @Getter
    private PatientDTO patientWithTreatment;

    @BeforeEach
    void setUp() {
        invoiceRepository.deleteAll();
        accountant.save(patientWithMedicine);
        accountant.save(patientWithTreatment);
    }


    @Test
    void testMedicineInvoice() {
        Invoice invoice = manager.getAll().get(0);
        assertThat(invoice.getKind()).isEqualTo(Kind.MEDICINE);
    }

    @Test
    void testTreatmentInvoice() {
        Invoice invoice = manager.getAll().get(1);
        assertThat(invoice.getKind()).isEqualTo(Kind.TREATMENT);
    }

    @Test
    void updatePayment() {
        Invoice invoice = manager.getAll().get(0);
        assertThat(invoice.isPaid()).isFalse();
        manager.updatePayment(invoice.getId());

        invoice = manager.getAll().get(0);
        assertThat(invoice.isPaid()).isTrue();
    }
}