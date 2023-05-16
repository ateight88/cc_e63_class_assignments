import Library.Library;
import Library.Book;
import Library.Borrower;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.*;

public class LibraryTest {

    private Book book1;
    private Book book2;
    private Book book3;

    private Library library;
    private Library library2;

    private Borrower borrower;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("The Wild Sheep Chase", "Haruki Murakami", "Mystery");
        book2 = new Book("The Crow Road", "Ian Banks", "Mystery");
        book3 = new Book("Pride & Prejudice", "Jane Austen", "Classics");

        borrower = new Borrower("John");

        library = new Library(1);
        library2 = new Library(4);
    }

    @Test
    public void canReportCapacity() {
        assertEquals(true, library.hasCapacity());
    }

    @Test
    public void canAddBook__whenThereIsRoom() {
        library.addBook(book1);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void cantAddBook__whenNoRoom() {
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(1, library.bookCount());
    }

    @Test
    public void checkBookAvailable() {
        assertEquals(false, library.checkInStock(book1));
    }

    @Test
    public void checkBookAvailable__true() {
        library.addBook(book1);
        assertEquals(true, library.checkInStock(book1));
    }

    @Test
    public void testCanLendBook() {
        // arrange
        library.addBook(book1);

        // act
        library.loanBook(book1, borrower);

        // assert
        assertEquals(1, borrower.bookCount());
        assertEquals(0, library.bookCount());
        assertEquals(false, library.checkInStock(book1));
    }

    @Test
    public void updatesGenreHashMap__whenBookAdded(){
        //arrange
        library2.addBook(book1);
        library2.addBook(book2);
        library2.addBook(book3);

        assertEquals(2, library2.checkGenreFrequency("Mystery"));
        assertEquals(1, library2.checkGenreFrequency("Classics"));

    }

}
//public class LibraryTest {
//
//
//    private Library library;
//    private Library library2;
//
//    private Borrower borrower;
//
//    @Before
//    public void before() throws Exception {
//        Book book1 = new Book("Happy Place", "Emily Henry", "Romance");
//        Book book2 = new Book("Hello Beautiful", "Ann Napolitano", "Historical Fiction");
//        Book book3 = new Book("I’m Glad My Mom Died", "Jennette McCurdy", "Memoir");
//
//        borrower = new Borrower("Bill");
//
//        ArrayList<Book> collection = new ArrayList<>();
//        collection.add(book1);
//        collection.add(book2);
//        collection.add(book3);
//
//        HashMap<String, Integer> genreList = new HashMap<>();
//        genreList.put("Romance", 1);
//        genreList.put("Historical Fiction", 1);
//        genreList.put("Memoir", 1);
//
//        library = new Library(3, collection, genreList);
////        library2 = new Library(3, collection, genreList);
//    }
//
//    @Test
//    public void canReportLimit() {
//        assertTrue(library.hasLimit());
//    }
//
//    @Test
//    public void canAddBook_whenThereIsRoom() {
//        library.addBook(book1);
//        assertEquals(1, borrower.bookCount());
//    }
//
//    @Test
//    public void cantAddBook_whenNoRoom() {
//        library.addBook(book1);
//        library.addBook(book2);
//        assertEquals(1, borrower.bookCount());
//    }
//
//    @Test
//    public void checkBookAvailable() {
//        assertFalse(library.checkInStock(book1));
//    }
//
//    @Test
//    public void checkBookAvailable_true() {
//        library.addBook(book1);
//        assertTrue(library.checkInStock(book1));
//    }
//
//    @Test
//    public void testCanLendBook() {
//        // arrange
//        library.addBook(book1);
//
//        // act
//        library.lendBook(book1, borrower);
//
//        // assert
//        assertEquals(1, borrower.bookCount());
//        assertEquals(0, library.checkGenreCount("Romance"));
//        assertFalse(library.checkInStock(book1));
//    }
//
//    @Test
//    public void updatesGenreHashMap_whenBookAdded(){
//        //arrange
//        assertEquals(1, library2.checkGenreCount("Romance"));
//        assertEquals(1, library2.checkGenreCount("Historical Fiction"));
//        assertEquals(1, library2.checkGenreCount("Memoir"));
//
//        library2.addBook(new Book("New Book", "New Author", "Romance"));
//        library2.addBook(new Book("Another Book", "Another Author", "Romance"));
//        library2.addBook(new Book("Different Book", "Different Author", "Classics"));
//
//        assertEquals(1, library2.checkGenreCount("Romance"));
//        assertEquals(1, library2.checkGenreCount("Historical Fiction"));
//        assertEquals(1, library2.checkGenreCount("Memoir"));
//        assertEquals(2, library2.checkGenreCount("Classics"));
//    }
//}
