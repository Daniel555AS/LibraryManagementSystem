import org.example.Book;
import org.example.Student;
import org.example.LoanManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.example.LibraryDatabase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoanManagerTest {
    
    @Mock
    LibraryDatabase libraryDatabase;
    
    @InjectMocks
    private LoanManager loanManager;
    
    @BeforeEach
    public void setUp() {
         MockitoAnnotations.openMocks(this);
    } // public void setUp() 
    
    @Test
    public void testAddBook() {
        Book book1 = new Book("B005", "El Quijote", "Miguel Saavedra");
        loanManager.addBook(book1);
        assertTrue(loanManager.getBooks().contains(book1));
    } // public void testAddBook() 
    
    @Test
    public void testRegisterStudent() {
       Student student = new Student("568", "Daniel Arias");
       loanManager.registerStudent(student);
       assertTrue(loanManager.getStudents().contains(student));
    } // public void testRegisterStudent() 
    
    @Test
    public void testLendBookWhenStudentAndBookAreRegistered() {
        Student student1 = new Student("978", "Juan Perez");
        Book book1 = new Book("B006", "La IlIada", "Homero");
        loanManager.addBook(book1);
        loanManager.registerStudent(student1);
        assertTrue(loanManager.lendBook("B006", "978"));
        assertFalse(book1.isAvailable());
    } // public void testLendBook() 
    
    @Test
    public void testLendBookWhenStudentAndBookAreNotRegistered() {
      assertFalse(loanManager.lendBook("B007", "555"));
    } // Public void testLendBookWhenStudentAndBookAreNotRegistered() 
       
    @Test
    public void testReceiveReturnedBookWhenStudentAndBookAreRegistered() {
        Student student = new Student("426", "Camilo Rios");
        Book book = new Book("B008", "La Divina Comedia", "Dante Alighieri");
        loanManager.addBook(book);
        loanManager.registerStudent(student);
        assertTrue(loanManager.lendBook("B008", "426"));
        loanManager.receiveReturnedBook("B008", "426");
        assertTrue(book.isAvailable());
        assertFalse(student.getBorrowedBooks().contains(book));
    } // public void testReceiveReturnedBook() 
     
} // public class LoanManagerTest
