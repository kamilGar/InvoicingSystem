package pl.futurecollars.invoicing.util

import org.junit.jupiter.api.Assertions
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase
import pl.futurecollars.invoicing.model.Invoice
import spock.lang.Specification

import static pl.futurecollars.invoicing.TestHelpers.invoice

class JsonServiceTest extends Specification {

    private Database database
    private List<Invoice> invoices

    def setup() {
        database = new InMemoryDatabase();
        invoices = (1..10).collect { invoice(it) }

    }

    def "should convert invoice to JSON object (String) with invoice details"() {
        given:
        JsonService jsonService = new JsonService();
        when:
        Invoice testInvoice = invoice(1)
        String result = jsonService.toJasonObject(testInvoice);
        then:
        Assertions.assertEquals(String.class, result.getClass())

    }

    def "should convert JSON file to Java object (Invoice)"() {
        given:
        JsonService jsonService = new JsonService();
        when:
        Invoice testInvoice = invoice(1)
        String jsonFile = jsonService.toJasonObject(testInvoice);
        Invoice result = jsonService.toJavaObject(jsonFile);
        then:
        Assertions.assertEquals(Invoice.class, result.getClass())

    }

}