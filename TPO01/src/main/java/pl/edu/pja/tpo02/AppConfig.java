package pl.edu.pja.tpo02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("default")
    public Format defaultFormat() {
        return new Default();
    }

    @Bean
    @Profile("uppercase")
    public Format uppercaseFormat() {
        return new Uppercase();
    }

    @Bean
    @Profile("lowercase")
    public Format lowercaseFormat() {
        return new Lowercase();
    }

    @Bean
    public EntryRepository entryRepository() {
        return new EntryRepository();
    }

    @Bean
    public FileService fileService(@Value("${pl.edu.pja.tpo02.filename}") String filename) {
        return new FileService(filename);
    }

    @Bean
    public FlashcardsController flashcardsController(EntryRepository entryRepository, FileService fileService, Format format) {
        return new FlashcardsController(entryRepository, fileService, format);
    }
}
