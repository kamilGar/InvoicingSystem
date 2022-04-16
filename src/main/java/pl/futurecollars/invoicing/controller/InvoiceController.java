package pl.futurecollars.invoicing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.InMemoryDatabase;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.service.InvoiceService;
import java.util.List;

@RestController
@RequestMapping("invoices")
public class InvoiceController {

    private InvoiceService service;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.service = invoiceService;
    }

    @PostMapping
    public int addNewInvoice(@RequestBody Invoice invoice) {
        return service.save(invoice);
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public void updateInvoice(@PathVariable Integer id, @RequestBody Invoice newInvoice) {
        service.update(id, newInvoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Integer id) {
        service.delete(id);
    }

    // trying another way

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> deleteById(@PathVariable int id) {
        return invoiceService.getById(id)
                .map(invoice -> ResponseEntity.ok().body(invoice))
                .orElse(ResponseEntity.notFound().build());
    }

     */

}


