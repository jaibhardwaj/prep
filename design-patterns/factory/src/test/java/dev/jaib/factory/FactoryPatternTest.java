package dev.jaib.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryPatternTest {

    @Test
    public void testCreatePdf() {
        Document doc = DocumentFactory.createDocument("pdf");
        assertNotNull(doc);
        assertTrue(doc instanceof PdfDocument);
        assertEquals("Parsing PDF document content.", doc.parse());
    }

    @Test
    public void testCreateWord() {
        Document doc = DocumentFactory.createDocument("word");
        assertNotNull(doc);
        assertTrue(doc instanceof WordDocument);
        assertEquals("Parsing Word document content.", doc.parse());
    }

    @Test
    public void testInvalidType() {
        assertThrows(IllegalArgumentException.class, () -> {
            DocumentFactory.createDocument("excel");
        });
    }

    @Test
    public void testEmptyType() {
        assertNull(DocumentFactory.createDocument(""));
        assertNull(DocumentFactory.createDocument(null));
    }
}
