package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Patron> patrons;
    private Notifier notifier;


    public Library(Notifier notifier) {
        this.books = new HashMap<>();
        this.patrons = new HashMap<>();
        this.notifier = notifier;
    }

    public int getNumberOfBooks(){return books.size();}
    public int getNumberOfPatrons(){return patrons.size();}

    // Book - Add, Remove Methods
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Error: Book with ISBN " + book.getIsbn() + " already exists.");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Book added Successfully. " + book.getTitle());
        }
    }

    public void removeBook(String isbn) {
        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Book with ISBn " + isbn + " removed successfully.");
        } else {
            System.out.println("Error: Book with ISBN " + isbn + "not found.");
        }
    }

    //Search Method
    // searchBook method
    public List<Book> searchBook(String query) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getIsbn().equalsIgnoreCase(query)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Method to search for patrons by name, contact info, or ID.
    public List<Patron> searchPatron(String query) {
        List<Patron> foundPatrons = new ArrayList<>();
        // Iterate through all values (Patron objects) in the map.
        for (Patron patron : patrons.values()) {
            // We make the search case-insensitive using toLowerCase().
            if (patron.getName().toLowerCase().contains(query.toLowerCase()) ||
                    patron.getContactInfo().toLowerCase().contains(query.toLowerCase()) ||
                    patron.getPatronId().equalsIgnoreCase(query)) {
                foundPatrons.add(patron);
            }
        }
        return foundPatrons;
    }


    // Management Methods - Patron
    public void registerPatron(Patron patron) {
        if (patrons.containsKey(patron.getPatronId())) {
            System.out.println("Error: Patron with ID " + patron.getPatronId() + " already registered.");
        } else {
            patrons.put(patron.getPatronId(), patron);
            System.out.println("Patron registered successfully. " + patron.getName());
        }
    }

    // Lending Process
    public void borrowBook(String isbn, String patronId) {
        if (books.containsKey(isbn) && patrons.containsKey(patronId)) {
            Book book = books.get(isbn);
            Patron patron = patrons.get(patronId);

            if (book.getStatus() == BookStatus.AVAILABLE) {
                patron.borrowBook(book);
                book.setStatus(BookStatus.CHECKED_OUT);
                System.out.println(patron.getName() + " has borrowed " + book.getTitle() + " successfully.");
            } else if (book.getStatus() == BookStatus.CHECKED_OUT) {
                System.out.println("Error: The book " + book.getTitle() + " is already checked out.");
            } else { // RESERVED
                System.out.println("Error: The book " + book.getTitle() + " is reserved and cannot be borrowed.");
            }
        } else {
            System.out.println("Error: Book or Patron not found. Please check the ISBN and Patron ID.");
        }
    }

    private void notifyPatron(Book book) {
        // Check if there are any patrons on the reservation list
        if (!book.getReservedBy().isEmpty()) {
            Patron firstInLine = book.getReservedBy().get(0);
            String message = "The book '" + book.getTitle() + "' is now available for you to borrow. Please pick it up within 24 hours.";
            notifier.sendNotification(firstInLine, message);
            book.getReservedBy().remove(0); // Remove the first patron after notifying them
        }
    }


    public void returnBook(String isbn, String patronId) {
        if (books.containsKey(isbn) && patrons.containsKey(patronId)) {
            Book book = books.get(isbn);
            Patron patron = patrons.get(patronId);

            if (patron.getBorrowedBooks().contains(book)) {
                patron.returnBook(book);
                System.out.println(patron.getName() + " has returned " + book.getTitle() + " successfully.");

                // Now, check for reservations
                if (!book.getReservedBy().isEmpty()) {
                    notifyPatron(book);
                    book.setStatus(BookStatus.RESERVED);
                } else {
                    book.setStatus(BookStatus.AVAILABLE);
                }
            } else {
                System.out.println("Error: " + patron.getName() + " does not have this book to return.");
            }
        } else {
            System.out.println("Error: Book or Patron not found. Please check the ISBN and Patron ID.");
        }
    }

        // --- Reservation System (New) ---
        public void reserveBook(String isbn, String patronId) {
            if (books.containsKey(isbn) && patrons.containsKey(patronId)) {
                Book book = books.get(isbn);
                Patron patron = patrons.get(patronId);

                if (book.getStatus() == BookStatus.AVAILABLE) {
                    System.out.println("The book " + book.getTitle() + " is available and does not need to be reserved.");
                } else {
                    if (!book.getReservedBy().contains(patron)) {
                        book.getReservedBy().add(patron);
                        book.setStatus(BookStatus.RESERVED);
                        System.out.println("Reservation successful for " + book.getTitle() + " by " + patron.getName() + ".");
                    } else {
                        System.out.println("Error: " + patron.getName() + " has already reserved this book.");
                    }
                }
            } else {
                System.out.println("Error: Book or Patron not found.");
            }
        }


    }





