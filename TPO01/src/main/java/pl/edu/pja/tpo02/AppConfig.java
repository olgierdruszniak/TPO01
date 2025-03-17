package pl.edu.pja.tpo02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public EntryRepository entryRepository() {
        return new EntryRepository();
    }

    @Bean
    public FileService fileService(@Value("${pl.edu.pja.tpo02.filename}") String filename) {
        return new FileService(filename);
    }

    @Bean
    public FlashcardsController flashcardsController(EntryRepository entryRepository, FileService fileService) {
        return new FlashcardsController(entryRepository, fileService);
    }
}
