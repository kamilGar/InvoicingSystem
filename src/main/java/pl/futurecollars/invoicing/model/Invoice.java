package pl.futurecollars.invoicing.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Invoice {

    private int id;
    private LocalDate date;
    private Company companyFrom;
    private Company companyFor;
    private List<InvoiceEntry> invoiceEntries;

    public Invoice(LocalDate date, Company companyFrom, Company companyFor, List<InvoiceEntry> invoiceEntries) {
        this.date = date;
        this.companyFrom = companyFrom;
        this.companyFor = companyFor;
        this.invoiceEntries = invoiceEntries;
    }
}
