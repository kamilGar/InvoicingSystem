package pl.futurecollars.invoicing.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.model.Invoice;

@Service
public class JsonService {

    private ObjectMapper objectMapper;

    public JsonService() {
        objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public String toJasonObject(Invoice invoice) {

        try {
            return objectMapper.writeValueAsString(invoice);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Problems encountered when processing (parsing, generating)");

        }

    }

    public Invoice toJavaObject(String jsonString) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, Invoice.class);


    }

}
