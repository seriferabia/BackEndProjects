package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InvoiceParser {
    private final PriceManager priceManager;
    private final PatientManager patientManager;

    public Invoice getInvoice(PatientDTO patientDTO, Patient patient) {
        return Invoice.builder().patient(patient)
                .kind(patientManager.getKind(patientDTO))
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .provided(patientManager.getProvided(patientDTO))
                .cost(priceManager.calculatePrice(patientDTO))
                .paid(false)
                .timestamp(LocalDateTime.now()).build();
    }
}
