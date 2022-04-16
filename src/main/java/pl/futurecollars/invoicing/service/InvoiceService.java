package pl.futurecollars.invoicing.service;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;

@Service
public class InvoiceService {

    private final Database db;

    public InvoiceService(@Qualifier("inMemoryDatabase") Database db) {
        this.db = db;
    }

    public int save(Invoice invoice) {
        return db.save(invoice);
    }

    public Invoice getById(int id) {
        return db.getById(id);
    }

    public ArrayList<Invoice> getAll() {
        return db.getAll();
    }

    public void update(int id, Invoice updatedInvoice) {
        db.update(id, updatedInvoice);
    }

    public void delete(int id) {
        db.delete(id);
    }
}
