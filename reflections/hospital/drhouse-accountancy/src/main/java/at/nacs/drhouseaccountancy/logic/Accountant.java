package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {
    private final InvoiceRepository invoiceRepository;
    private final PatientRepository patientRepository;
    private final InvoiceParser parser;
    private final PatientManager patientManager;

    public PatientDTO save(PatientDTO patientDTO) {
        Patient patient = patientManager.getPatient(patientDTO);
        patientRepository.save(patient);
        Invoice invoice = parser.getInvoice(patientDTO, patient);
        invoiceRepository.save(invoice);
        return patientDTO;
    }
}
