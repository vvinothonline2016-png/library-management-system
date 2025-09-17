# library-management-system

This project is a simple, console-based Library Management System built in Java. It is designed to demonstrate core Object-Oriented Programming (OOP) principles, the use of Java Collections, and basic software design patterns.

Bottom-Top Approach

**Features**

**Book Management**:        Add, remove, and search for books by title, author, or ISBN.

**Patron Management:**      Register new library members and search for them by name, contact information, or ID.

**Lending System:**         Patrons can borrow and return books.
                            The system prevents a book from being borrowed if it is already checked out.

**Reservation System:**     Patrons can reserve books that are currently checked out.
                            A notification is sent to the next patron in line when a reserved book is returned.

**Logging:**                Important events and errors are logged to the console for monitoring.

**Project Structure**

       The project is structured into a logical set of classes, each with a single responsibility:

                                         Book.java: Represents a single book.
                                         
                                         Patron.java: Represents a library member.
                                         
                                         Library.java: The central class that manages all books, patrons, and the lending process. It contains the main business logic.
                                         
                                         BookStatus.java: An enum that defines the possible states of a book (e.g., AVAILABLE, CHECKED_OUT).
                                         
                                         Notifier.java: An interface that defines the contract for sending notifications.
                                         
                                         EmailNotifier.java: A concrete class that implements the Notifier interface, handling notifications via console output.
                                         
                                        LibraryTest.java: The main class used to demonstrate and test the functionality of the entire system.

**How to Run**

              Compile all the Java files in the domain package.
              
              Run the LibraryTestMain.java file.
              
              Observe the console output to see the system's features in action.

--------------------------------------------------------------------------------------------


-------------------------**-CLass Diagram-**---------------------------------------------------

+----------------+
|     Book       |
+----------------+
| - isbn: String |
| - title: String|
| - author: String|
| - publicationYear: int |
| - status: BookStatus |
| - reservedBy: List<Patron> |
+----------------+
| + getIsbn()    |
| + getTitle()   |
| + getAuthor()  |
| + getPublicationYear() |
| + getStatus()  |
| + getReservedBy() |
+----------------+

+------------------+
|    Patron        |
+------------------+
| - id: String     |
| - name: String   |
| - contactInfo: String |
| - borrowedBooks: List<Book> |
+------------------+
| + borrowBook()   |
| + returnBook()   |
| + getHistory()   |
+------------------+

+------------------+
|    Library       |
+------------------+
| - books: List<Book> |
| - patrons: List<Patron> |
| - notifier: Notifier |
+------------------+
| + addBook()      |
| + removeBook()   |
| + updateBook()   |
| + searchBook()   |
| + registerPatron()|
| + checkoutBook() |
| + returnBook()   |
+------------------+

+------------------+
|   <<interface>>  |
|    Notifier      |
+------------------+
| + sendNotification(Patron, String) |
+------------------+

+------------------+
|  EmailNotifier   |
+------------------+
| + sendNotification(Patron, String) |
+------------------+

+------------------+
|   BookStatus     |
+------------------+
| AVAILABLE        |
| CHECKED_OUT      |
| RESERVED         |
+------------------+


**Relationships:**

Library → Book (manages many books)

Library → Patron (manages many patrons)

Library → Notifier (uses interface for notifications)

EmailNotifier → Notifier (implements interface)

Book → Patron (reservedBy list)

Patron → Book (borrowedBooks list)


----------------------------------------------------------------------------------------------------------
```mermaid
classDiagram
    class Book {
        - String isbn
        - String title
        - String author
        - int publicationYear
        - BookStatus status
        - List~Patron~ reservedBy
        + getIsbn()
        + getTitle()
        + getAuthor()
        + getPublicationYear()
        + getStatus()
        + getReservedBy()
    }

    class Patron {
        - String id
        - String name
        - String contactInfo
        - List~Book~ borrowedBooks
        + borrowBook()
        + returnBook()
        + getHistory()
    }

    class Library {
        - List~Book~ books
        - List~Patron~ patrons
        - Notifier notifier
        + addBook()
        + removeBook()
        + updateBook()
        + searchBook()
        + registerPatron()
        + checkoutBook()
        + returnBook()
    }

    class Notifier {
        <<interface>>
        + sendNotification(Patron, String)
    }

    class EmailNotifier {
        + sendNotification(Patron, String)
    }

    class BookStatus {
        <<enum>>
        AVAILABLE
        CHECKED_OUT
        RESERVED
    }

    Library --> Book : manages
    Library --> Patron : manages
    Library --> Notifier : uses
    EmailNotifier ..|> Notifier
    Book --> Patron : reservedBy
    Patron --> Book : borrowedBooks

```mermaid

--------------------------------------------------------------------------------------------





