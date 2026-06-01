package dev.jaib.factory;

public class WordDocument implements Document {
    @Override
    public String parse() {
        return "Parsing Word document content.";
    }
}
