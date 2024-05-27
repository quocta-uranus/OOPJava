package Exercise7;

import java.util.List;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String isbn;
    private List<String> chapters;

    public Book(String title, String author, String publisher, int year, String isbn, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
        this.chapters = chapters;
    }

 
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Tieu de : '" + title + '\'' +
                ", Tac gia : '" + author + '\'' +
                ", Nha xuat ban : " + publisher + '\'' +
                ", Nam : " + year +
                ", ISBN : '" + isbn + '\'' +
                ", Chuong : " + chapters +
                '}';
    }
}
