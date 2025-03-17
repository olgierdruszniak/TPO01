package pl.edu.pja.tpo02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntryRepository {
    private List<Entry> entries;

    public EntryRepository() {
        entries = new ArrayList<Entry>();
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getEntries(){
        return entries;
    }

    public Entry getRandom(){
        if(entries.isEmpty()){
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(entries.size());
        Entry entry = entries.get(index);
        return entry;
    }
}
