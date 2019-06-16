package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceEndpoint {
    private final InvoiceManager manager;

    @GetMapping
    List<Invoice> get() {
        return manager.getAll();
    }

    @PutMapping("/{id}/paid")
    void put(@PathVariable Long id) {
        manager.updatePayment(id);
    }
}