package dev.jaib.factory;

public class PdfDocument implements Document {
    @Override
    public String parse() {
        return "Parsing PDF document content.";
    }
}
