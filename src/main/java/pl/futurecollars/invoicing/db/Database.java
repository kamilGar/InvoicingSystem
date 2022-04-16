package pl.futurecollars.invoicing.db;

import java.util.ArrayList;
import java.util.Optional;

import pl.futurecollars.invoicing.model.Invoice;

public interface Database {

    int create(Invoice invoice);

    int save(Invoice invoice);

    Invoice getById(int id);

    ArrayList<Invoice> getAll();

    void update(int id, Invoice updatedInvoice);

    void delete(int id);
}
