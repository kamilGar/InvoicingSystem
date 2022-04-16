package pl.futurecollars.invoicing.service

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.InMemoryDatabase;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;
import pl.futurecollars.invoicing.model.Vat;
import spock.lang.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

class InvoiceServiceIntegrationTest {
    private InvoiceService service;
    private List<Invoice> invoices;

    def setup() {
        Database db = new InMemoryDatabase();
        service = new InvoiceService(db);

        invoices = (1..12).collect { invoice(it) }

        /*


    def setup() {
        Database db = new InMemoryDatabase();
        service = new InvoiceService(db);

       //invoices = (1..12).collect { invoice(it) }


 */
    }
}