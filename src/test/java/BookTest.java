import org.example.Book;
import org.example.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BookTest {
    
    private Book book;
    
    @BeforeEach
    public void setUp() {
        book = new Book("B010", "Test", "Prueba");
    }
    
    @Test
    public void testGetId() {
        assertEquals("B010", book.getId());
    }
    
    @Test
    public void testGetTitle() {
        assertEquals("Test", book.getTitle());
    }
    
    @Test
    public void testGetAuthor() {
        assertEquals("Prueba", book.getAuthor());
    }
    
} // publci class BookTest
