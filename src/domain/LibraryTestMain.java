package domain;

import java.util.List;
public class LibraryTestMain {

    public static void main(String[] args) {

        System.out.println("================================= ");
        System.out.println("     Welcome to My Library    ");   // initializing
        System.out.println("================================ ");

        //initializing Library and creating objects

        Notifier notifier = new EmailNotifier();
        Library myLibrary = new Library(notifier);


        Book book1 = new Book("001-A", "Old Boy", "John Willey", 1998);
        Book book2 = new Book("002-B", "Bad boys", "Jake Willson", 1994);
        Book book3 = new Book("002-B", "Bad boys", "Jake Willson", 1994); //Duplicate to test
        Book book4 = new Book("004-E", "Golden Boat", "Lake Arthur", 2001);

        Patron patron1 = new Patron("Vinoth", "vinoth@gmail.com");
        Patron patron2 = new Patron("Charumathy", "charumathy@gmail.com");
        Patron patron3 = new Patron("David", "david@gmail.com");

        System.out.println("\n Intial Objects created successfully.\n");

        // Testing book and Patron Management

        System.out.println("--------Registering Books and Patrons---------");
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3); // this should print error message due to duplicate ISBN
        myLibrary.addBook(book4);

        myLibrary.registerPatron(patron1);
        myLibrary.registerPatron(patron2);
        myLibrary.registerPatron(patron3);

        System.out.println("\n  Books and Patrons registered /n");

        // Testing Search Functionality
        System.out.println("------Search for a Book ----");

        List<Book> foundBooks = myLibrary.searchBook("Old Boy");
        System.out.println(" Results for Old Boy " + foundBooks.size() + " books found");
        for (Book book : foundBooks) {
            System.out.println(" - " + book.getTitle() + " by " + book.getAuthor());
        }

        System.out.println("Search Book Tested ");

        System.out.println("------Search for a Patron ----");

        List<Patron> foundPatrons = myLibrary.searchPatron("Charumathy");
        System.out.println(" Search result for Charumathy " + foundPatrons.size() + " patrons found");
        for (Patron patron : foundPatrons) {
            System.out.println(" - " + patron.getName() + " with ID " + patron.getPatronId() + patron.getContactInfo());
        }

        System.out.println(" \n Patron Search Tested /n ");

       // Test Borrowing and Reservation ---
                System.out.println("--- Testing Borrow, Return, and Reservation Process ---");

        // Scenario 1: Successful borrow
        System.out.println("\nScenario 1: Patron borrows an available book.");
        myLibrary.borrowBook(book1.getIsbn(), patron1.getPatronId());

        // Scenario 2: Patron tries to borrow an already checked-out book
        System.out.println("\nScenario 2: Another patron tries to borrow the same book.");
        myLibrary.borrowBook(book1.getIsbn(), patron2.getPatronId());

        // Scenario 3: Patron reserves a checked-out book
        System.out.println("\nScenario 3: Patron 2 reserves the book.");
        myLibrary.reserveBook(book1.getIsbn(), patron2.getPatronId());

        // Scenario 4: Patron returns the book, triggering a notification
        System.out.println("\nScenario 4: The original patron returns the book.");
        myLibrary.returnBook(book1.getIsbn(), patron1.getPatronId());

        // Scenario 5: Patron tries to return a book they didn't borrow
        System.out.println("\nScenario 5: Patron 1 tries to return a different book.");
        myLibrary.returnBook(book2.getIsbn(), patron1.getPatronId());

        System.out.println("\n Borrow, return, and reservation logic tested.\n");

        // --- Final Check on Patron's Borrowed Books
        System.out.println("--- Final State of Patron " + patron1.getName() + " ---");
        System.out.println(patron1.toString());

        System.out.println("\n--- Final Library Inventory Status ---");
        System.out.println("Total books in inventory: " + myLibrary.getNumberOfBooks());
        System.out.println("Total patrons registered: " + myLibrary.getNumberOfPatrons());

        System.out.println("\n=================================================");
        System.out.println("            All tests completed successfully! ");
        System.out.println("=================================================");


    }
}
