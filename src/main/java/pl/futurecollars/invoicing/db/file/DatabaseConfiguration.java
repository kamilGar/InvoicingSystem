package pl.futurecollars.invoicing.db.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pl.futurecollars.invoicing.util.FileService;
import pl.futurecollars.invoicing.util.JsonService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public FileBasedDatabase fileBasedDatabase(FileService fileService, JsonService jsonService, IdService idService) throws IOException {
        Path filePath = Files.createTempFile("prefix", ".txt");
        return new FileBasedDatabase(fileService, jsonService, idService, filePath);
    }

    @Bean
    public IdService idService(FileService fileService) throws IOException {
        Path filePath = Files.createTempFile("idPrefix", ".txt");
        return new IdService(filePath, fileService);
    }

}
