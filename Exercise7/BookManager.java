package Exercise7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void sortBooksByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public void sortBooksByAuthor() {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
    }

    public void sortBooksByPublisher() {
        Collections.sort(books, Comparator.comparing(Book::getPublisher));
       
    }

    public void sortBooksByYear() {
        Collections.sort(books, Comparator.comparingInt(Book::getYear));
    }
}
