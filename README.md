# library-management-system

This project is a simple, console-based Library Management System built in Java. It is designed to demonstrate core Object-Oriented Programming (OOP) principles, the use of Java Collections, and basic software design patterns.

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
              
              Run the LibraryTest.java file.
              
              Observe the console output to see the system's features in action.





-------------------------**-CLass Diagram-**---------------------------------------------------

+-------------------+
|       Book        |
+-------------------+
| - isbn: String    |
| - title: String   |
| - author: String  |
| - status: BookStatus |
| - reservedBy: List<Patron> |
+-------------------+


+-------------------+
|      Patron       |
+-------------------+
| - patronId: String|
| - name: String    |
| - contactInfo: String |
| - borrowedBooks: List<Book> |
+-------------------+


+-------------------+
|      Library      |
+-------------------+
| - books: Map<String, Book>   |
| - patrons: Map<String, Patron> |
| - notifier: Notifier          |
+-------------------+


+-------------------+
|   BookStatus (enum) |
+-------------------+


+-------------------+
|   Notifier (interface) |
+-------------------+
        ^
        |
+-------------------+
|   EmailNotifier   |
+-------------------+


----------------------------------------------------------------------------------------------------------

<img width="1119" height="174" alt="image" src="https://github.com/user-attachments/assets/3ed02a73-4c9a-4969-85bf-c925e0ae32c2" />




