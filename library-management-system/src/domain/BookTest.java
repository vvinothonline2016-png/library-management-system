package domain;

public class BookTest {
    public static void main(String[] args) {
        // creating a book object
        Book book1 = new Book("1:A","Game", "Robert", 2008);

        //Accessing dta via getters(Encapsulation)
        System.out.println("Book Title : " + book1.getTitle());
        System.out.println("Book Author : " + book1.getAuthor());
        System.out.println("Book ISBN : " + book1.getIsbn());
        System.out.println("PublicationYear : " + book1.getPublicationYear());

        //toString() to print all details
        System.out.println("Full Book info: " + book1);

        // Testing updateDetails
        book1.updateDetails("Game - Revised Edition", "Robert", 2010);

        // Printing Updated Details
        System.out.println("After Update:");
        System.out.println("Book Title: " + book1.getTitle());
        System.out.println("Book Author: " + book1.getAuthor());
        System.out.println("Publication Year: " + book1.getPublicationYear());

        System.out.println("Full Book info: " + book1);
    }
}
