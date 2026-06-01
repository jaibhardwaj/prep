package dev.jaib.factory;

public class DocumentFactory {
    public static Document createDocument(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "pdf":
                return new PdfDocument();
            case "word":
                return new WordDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
