package pl.futurecollars.invoicing.db.file;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.util.FileService;
import pl.futurecollars.invoicing.util.JsonService;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
@Repository
@Primary
public class FileBasedDatabase implements Database {

    private HashMap<Integer, Invoice> fileBasedDatabase = new HashMap<>();
    private int id = 1;
    private final FileService fileService;
    private final JsonService jsonService;
    private final IdService idService;
    private final Path databasePath;

    @Override
    public int create(Invoice invoice) {
        fileBasedDatabase.put(id, invoice);
        return id++;
    }

    @Override
    public int save(Invoice invoice) {
        fileBasedDatabase.put(id, invoice);
        return id++;
    }

    @Override
    public Invoice getById(int id) {
        if (!fileBasedDatabase.containsKey(id)) {
            throw new IllegalArgumentException("there is no such id as " + id);
        }
        return fileBasedDatabase.get(id);
    }

    @Override
    public ArrayList<Invoice> getAll() {
        return new ArrayList<>(fileBasedDatabase.values());
    }

    @Override
    public void update(int id, Invoice updatedInvoice) {
        if (!fileBasedDatabase.containsKey(id)) {
            throw new IllegalArgumentException("there is no such id as " + id);
        }

        updatedInvoice.setId(id);
        fileBasedDatabase.put(id, updatedInvoice);
    }

    @Override
    public void delete(int id) {
        fileBasedDatabase.remove(id);
    }
}
