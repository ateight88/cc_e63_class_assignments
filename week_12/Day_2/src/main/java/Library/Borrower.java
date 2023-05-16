package Library;

import java.util.ArrayList;
public class Borrower {

    private String name;
    private ArrayList<Book> collection;

    public Borrower(String borrowerName) {
        this.name = borrowerName;
        this.collection = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public int bookCount() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        this.collection.add(book);
    }
}

//public class Borrower {
//    private String name;
//    private ArrayList<Book> selection;
//
//    public Borrower(String name) {
//        this.name = name;
//        this.selection = new ArrayList<Book>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public ArrayList<Book> getSelection() {
//        return selection;
//    }
//
//    public void setSelection(ArrayList<Book> selection) {
//        this.selection = selection;
//    }
//
//    public int bookCount() {
//        return this.selection.size();
//    }
//
//    public void addBook(Book book) {
//        this.selection.add(book);
//    }
//}
