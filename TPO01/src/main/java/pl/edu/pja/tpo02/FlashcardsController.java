package pl.edu.pja.tpo02;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

public class FlashcardsController {
    private EntryRepository repository;
    private FileService fileService;
    private Format format;

    public FlashcardsController(EntryRepository repository, FileService fileService, Format format) {
        this.repository = repository;
        this.fileService = fileService;
        this.format = format;
    }

    public void initialize() {
        fileService.loadEntries(repository);
    }

    public void saveData(){
        fileService.saveRepository(repository);
    }

    public void addWord(String polish, String english, String german) {
        Entry entry = new Entry(polish, english, german);
        repository.add(entry);
    }

    public void display(){
        List<Entry> entries = repository.getEntries();
        if(entries.isEmpty()){
            System.out.println("No flashcards found");
            return;
        }
        System.out.println("All flashcards found: ");
        for(Entry entry : entries){
            System.out.println("Polish: "+format.format(entry.getPolish())+" | English: "+format.format(entry.getEnglish())+" | German: "+format.format(entry.getGerman()));
        }
    }

    public void runTest(){
        Entry randomEntry = repository.getRandom();
        if(randomEntry == null){
            System.out.println("There are no words in a dictionary");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word to translation: "+format.format(randomEntry.getPolish()));

        System.out.print("English: ");
        String english = scanner.nextLine();

        System.out.print("German: ");
        String german = scanner.nextLine();

        System.out.println("Correct answer: "+randomEntry.getPolish()+" | "+randomEntry.getEnglish()+" | "+randomEntry.getGerman());
        System.out.println("Result:");

        boolean englishCorrect = randomEntry.getEnglish().equalsIgnoreCase(english);
        System.out.println("English: "+(englishCorrect?"Correct":"Incorrect. The answer is: "+randomEntry.getEnglish()));

        boolean germanCorrect = randomEntry.getGerman().equalsIgnoreCase(german);
        System.out.println("German: "+(germanCorrect?"Correct":"Incorrect. The answer is: "+randomEntry.getGerman()));
    }
}
