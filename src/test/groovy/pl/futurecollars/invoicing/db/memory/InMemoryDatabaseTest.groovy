package pl.futurecollars.invoicing.db.memory

import org.junit.jupiter.api.Assertions;
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase
import pl.futurecollars.invoicing.model.Invoice
import spock.lang.Specification

import static pl.futurecollars.invoicing.TestHelpers.invoice

class InMemoryDatabaseTest extends Specification {

    private Database database
    private List<Invoice> invoices

    def setup() {
        database = new InMemoryDatabase();
        invoices = (1..10).collect { invoice(it) }
    }

    def "should create an invoice and return id of created invoice"() {
        given:
        Invoice testInvoice = invoice(1)
        database.save(testInvoice)
        when:
        int result = database.create(testInvoice)
        then:
        Assertions.assertEquals(2, result)
    }

    def "should save invoices returning sequential id, invoice should have id set to correct value, get by id returns saved invoice"() {
        when:
        Invoice testInvoice = invoice(1)
        int result = database.save(testInvoice)
        then:
        Assertions.assertEquals(1, result)
    }

    def "should return an invoice by given id"() {
        given:
        Invoice testInvoice = invoice(1)
        database.save(testInvoice)
        when:
        Invoice result = database.getById(1)
        then:
        Assertions.assertEquals(testInvoice, result)

    }

    def "should returns empty collection if there were no invoices"() {
        expect:
        database.getAll().isEmpty()
    }

    def "should return all invoices in the database, deleted invoice is not returned"() {
        given:
        invoices.forEach({ database.save(it) })

        expect:
        database.getAll().size() == invoices.size()

        when:
        database.delete(1)

        then:
        database.getAll().size() == invoices.size() - 1
        database.getAll().forEach({ assert it.getId() != 1 })
    }

    def "should delete invoice with no existing id without any exception or error"() {
        expect:
        database.delete(111);
    }

    def "should update an Invoice"() {
        given:
        int id = database.save(invoices.get(0))

        when:
        database.update(id, invoices.get(1))

        then:
        database.getById(id) == invoices.get(1)
    }

    def "should throw an exeption when trying to update not existing invoice"() {
        when:
        database.update(333, invoices.get(1))

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == "there is no such id as 333"
    }


}