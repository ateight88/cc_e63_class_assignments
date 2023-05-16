import Library.Borrower;
import Library.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BorrowerTest {

    Book book;
    Borrower borrower;

    @Before
    public void setUp() throws Exception {
        book = new Book("Soul Music", "Terry Pratchett", "Fantasy");
        borrower = new Borrower("Bill");
    }

    @Test
    public void testCountOfBooks() {
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void testCanAddBook() {
        borrower.addBook(book);
        assertEquals(1, borrower.bookCount());
    }
}
