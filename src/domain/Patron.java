package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patron {
    private final String patronId;
    private String name;
    private String contactInfo;
    private List<Book> borrowedBooks;

    public Patron(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
        this.patronId = UUID.randomUUID().toString();
    }
    // getter methods
   public String getPatronId() {return patronId;}
   public String getName() {return name;}
   public String getContactInfo() {return contactInfo;}
   public List<Book> getBorrowedBooks() {return new ArrayList<>(borrowedBooks);}

   //Setter Methods
    public void setName(String name) {this.name = name;}
    public void setContactInfo(String contactInfo) {this.contactInfo = contactInfo;}

  //core behaviours
    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }
    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }
 @Override
    public String toString(){
        return "Patron{" +
                "patronId='" + patronId + '\'' +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ",borrowedBooks=" + borrowedBooks.size() +
                '}';
 }
 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron patron = (Patron) o;
        return Objects.equals(patronId, patron.patronId);
 }
 @Override
    public int hashCode(){
        return Objects.hash(patronId);
 }

}
