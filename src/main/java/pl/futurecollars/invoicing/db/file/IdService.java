package pl.futurecollars.invoicing.db.file;

import lombok.AllArgsConstructor;
import pl.futurecollars.invoicing.util.FileService;

import java.nio.file.Path;

public class IdService {

    private final Path idFilePath;
    private final FileService filesService;
    private int nextId = 1;

    public IdService(Path idFilePath, FileService fileService) {
        this.idFilePath = idFilePath;
        this.filesService = fileService;
    }

}
