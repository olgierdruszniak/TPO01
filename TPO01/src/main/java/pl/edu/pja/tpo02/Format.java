package pl.edu.pja.tpo02;

import org.springframework.stereotype.Service;

public interface Format {
    String format(String s);
}

class Default implements Format {
    @Override
    public String format(String s) {
        return s;
    }
}

class Uppercase implements Format {
    @Override
    public String format(String s) {
        return s.toUpperCase();
    }
}

class Lowercase implements Format {
    @Override
    public String format(String s) {
        return s.toLowerCase();
    }
}
