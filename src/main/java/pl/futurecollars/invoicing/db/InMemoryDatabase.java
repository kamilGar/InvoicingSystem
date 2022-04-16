package pl.futurecollars.invoicing.db;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.futurecollars.invoicing.model.Invoice;

@Data
@Repository
public class InMemoryDatabase implements Database {

    private HashMap<Integer, Invoice> invoiceInMemoryDatabase = new HashMap<>();
    private int id = 1;

    @Override
    public int create(Invoice invoice) {
        invoiceInMemoryDatabase.put(id, invoice);
        return id++;
    }

    @Override
    public int save(Invoice invoice) {
        invoiceInMemoryDatabase.put(id, invoice);
        return id++;
    }

    @Override
    public Invoice getById(int id) {
        if (!invoiceInMemoryDatabase.containsKey(id)) {
            throw new IllegalArgumentException("there is no such id as " + id);
        }
        return invoiceInMemoryDatabase.get(id);

    }
    @Override
    public ArrayList<Invoice> getAll() {
        return new ArrayList<>(invoiceInMemoryDatabase.values());
    }

    @Override
    public void update(int id, Invoice updatedInvoice) {
        if (!invoiceInMemoryDatabase.containsKey(id)) {
            throw new IllegalArgumentException("there is no such id as " + id);
        }

        updatedInvoice.setId(id);
        invoiceInMemoryDatabase.put(id, updatedInvoice);
    }

    @Override
    public void delete(int id) {
        invoiceInMemoryDatabase.remove(id);
    }
}
