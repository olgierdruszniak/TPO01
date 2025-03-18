package pl.edu.pja.tpo02;

import java.io.*;


public class FileService {
    String filename;

    public FileService(String filename) {
        this.filename = filename;
    }

    public void loadEntries(EntryRepository repository) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating flashcards.csv: " + e.getMessage());
            }
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 3){
                    repository.add(new Entry(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveRepository(EntryRepository repository) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Entry entry : repository.getEntries()){
                writer.write(entry.getPolish()+","+entry.getEnglish()+","+entry.getGerman());
                writer.newLine();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
