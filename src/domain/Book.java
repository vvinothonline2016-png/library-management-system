package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Book {
    private final String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private BookStatus status;
    private List<Patron> reservedBy;


    public Book(String isbn, String title, String author, int publicationYear){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;

        this.status = BookStatus.AVAILABLE;
        this.reservedBy = new ArrayList();
    }

     public String getIsbn() {return isbn;}
     public String getTitle() {return title;}
     public String getAuthor() {return author;}
     public int getPublicationYear() {return publicationYear;}
     public BookStatus getStatus() {return status;}
     public List<Patron> getReservedBy() {return reservedBy;}



    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public void setStatus(BookStatus status) { this.status = status; }

@Override
public String toString() {
    return "Book{" +
            "isbn='" + isbn + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", publicationYear=" + publicationYear +
            ", status=" + status +
            '}';
}
@Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
}
@Override
    public int hashCode(){
        return Objects.hash(isbn);
}
    public void updateDetails(String newTitle, String newAuthor, int newPublicationYear){
        this.title = newTitle;
        this.author = newAuthor;
        this.publicationYear = newPublicationYear;
    }

}

