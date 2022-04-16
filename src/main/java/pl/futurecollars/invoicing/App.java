package pl.futurecollars.invoicing;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.InMemoryDatabase;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;
import pl.futurecollars.invoicing.model.Vat;
import pl.futurecollars.invoicing.service.InvoiceService;
import pl.futurecollars.invoicing.util.FileService;
import pl.futurecollars.invoicing.util.JsonService;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);

/*
        FileService fileService = new FileService();
        //IdService
        //Database db = new FileBasedDatabase();
        Database db = new InMemoryDatabase();
        InvoiceService service = new InvoiceService(db);

        Company buyer = new Company("iCode Trust Sp. z o.o", "03072017", "ul. Listopadowa 24d 05-110 Legionowo");
        Company seller = new Company("Kamil Development", "20022020", "05-110 Jablonna, Sadowa 19");

        List<InvoiceEntry> products = List.of(
                new InvoiceEntry("Programming course", BigDecimal.valueOf(10000), BigDecimal.valueOf(2300), Vat.VAT_23));

        Invoice invoice = new Invoice(LocalDate.now(), buyer, seller, products);


        objectMapper.writeValue(new File("invoices.yml"), invoice);
        Invoice invoiceFromFile = objectMapper.readValue(new File("invoices.yml"), Invoice.class);
        System.out.println(invoiceFromFile);



        int id = service.save(invoice);

        service.getById(id);

        System.out.println(service.getAll());

        //service.delete(id);

        JsonService jsonService = new JsonService();
        String result = jsonService.toJasonObject(invoice);
        System.out.println(result.getClass().equals(String.class));

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.writeValue(new File("invoices.json"), invoice);
        Invoice invoiceFromFile = objectMapper.readValue(new File("invoices.json"), Invoice.class);
        System.out.println(invoiceFromFile);
*/

    }

}
