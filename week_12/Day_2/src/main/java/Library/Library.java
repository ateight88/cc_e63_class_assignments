package Library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private int capacity;
    private ArrayList<Book> collection;
    private HashMap<String, Integer> genreHashmap;

    public Library(int capacity) {
        this.capacity = capacity;
        this.collection = new ArrayList<>();
        this.genreHashmap = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasCapacity() {
        return capacity > collection.size();
    }

    public int bookCount() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        if(hasCapacity()){
            this.collection.add(book);
            this.addToGenreHashmap(book);
        }
    }

    public void addToGenreHashmap(Book book){

        String genre = book.getGenre();

        //if the genre already exists in the hashmap, extract the existing count and assign it to the variable 'counter'
        if(this.genreHashmap.containsKey(genre)){
            int counter = genreHashmap.get(genre);

            // add one to the counter
            counter++;

            //put the key and new value back into the hashmap
            this.genreHashmap.put(genre, counter);

        } else {

            this.genreHashmap.put(genre, 1);
        }
    }

    public void loanBook(Book book, Borrower borrower) {
        // check if book in book collection
        if(this.collection.contains(book)){
            // if it is, remove book from collection
            this.collection.remove(book);

            // add to borrower
            borrower.addBook(book);
        }
    }

    public boolean checkInStock(Book book) {
//        return this.collection.contains(book);
        for(Book individualBook:this.collection){
            if(individualBook == book){
                return true;
            }
        }
        return false;
    }

    public int checkGenreFrequency(String genre) {
        return this.genreHashmap.get(genre);
    }
}

//public class Library {
//    private int limit;
//    private final ArrayList<Book> collection;
//    private final HashMap<String, Integer> genreList;
//
//    public Library(int limit, ArrayList<Book> collection, HashMap<String, Integer> genreList) {
//        this.limit = limit;
//        this.collection = collection;
//        this.genreList = genreList;
//    }
//
//    public int getLimit() {
//        return limit;
//    }
//
//    public boolean hasLimit() {
//        return limit > collection.size();
//    }
//
////    public void addToGenreList(Book book){
////
////        String genre = book.getGenre();
////
////        if(this.genreList.containsKey(genre)){
////            int counter = genreList.get(genre);
////            counter++;
////            this.genreList.put(genre, counter);
////
////        } else {
////
////            this.genreList.put(genre, 1);
////        }
////    }
//    public void addToGenreList(Book book) {
//        String genre = book.getGenre();
//        this.genreList.compute(genre, (key, value) -> (value == null) ? 1 : value + 1);
//    }
//
//
//    public void lendBook(Book book, Borrower borrower) {
//        if(this.collection.contains(book)){
//            this.collection.remove(book);
//            borrower.addBook(book);
//        }
//    }
//
//    public boolean checkInStock(Book book) {
//        for(Book singleBook : this.collection){
//            if(singleBook == book){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int checkGenreCount(String genre) {
//        return this.genreList.get(genre);
//    }
//
//    public void addBook(Book book) {
//        if (hasLimit() && collection.size() < limit) {
//            collection.add(book);
//            addToGenreList(book);
//        }
//    }
//}
