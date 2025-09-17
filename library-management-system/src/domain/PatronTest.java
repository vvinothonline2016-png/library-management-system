package domain;

public class PatronTest {
    public static void main(String[] args){

        //creating two book objects to use for testing
        Book book1 = new Book ("1-B", "Challenger", "Coedy Hunter", 1940);
        Book book2 = new Book ("1-C", "Moreover", "Billey", 1942);

        // Creating a Patron Object
        System.out.println("-------------New Patron----------");
        Patron patron1 = new Patron("Arvind", "Arvind@gmail.com");
        System.out.println("New Patron Details:" + patron1.toString());

        //Test Core Behaviour - Borrowing Books
        System.out.println("------Testing borrowBook() behaviour");
        patron1.borrowBook(book1);
        patron1.borrowBook(book2);
        System.out.println("Patron after Borrowing two Books:" + patron1.toString());
        System.out.println("Number of books borrowed:" + patron1.getBorrowedBooks().size());
        System.out.println("Patron ID:" + patron1.getPatronId());

        System.out.println("-------------------------------------");
        System.out.println("Get Patron Full Info:" + patron1);

        // Test Core Behaviour - Returning Books
        System.out.println(" ---------Testing return behaviour()------");
        patron1.returnBook(book1);
        System.out.println("Patron after returning one Book:" + patron1.toString());
        System.out.println("Number of books Not returned:" + patron1.getBorrowedBooks().size());

        //Setters
        System.out.println("--------testing setter methods----");
        patron1.setName("Arvind S");
        System.out.println("Patron after name updated:" + patron1.getName());

        // Test equals() and hashcode()
        System.out.println("-------demonstrating equals() and hashcode()");
        Patron patron2 = new Patron("Jane Smith", "janesmith@gmail.com");
        Patron patron3 = new Patron("Jane Smith", "janesmith.gmail.com"); // New Object with different ID

        System.out.println("Are patron2 and patron3 equal? " + patron2.equals(patron3));
        System.out.println("This is because they have different IDs.");
        System.out.println("Are patron1 and patron2 equal? " + patron1.equals(patron2)); // for testing what happen if i compare with patron1
        System.out.println("Hash code for patron2: " + patron2.hashCode());
        System.out.println("Hash code for patron3: " +  patron3.hashCode());
        System.out.println("checking hash code with patron1");
        System.out.println("Hash code for patron1: " + patron1.hashCode());

        System.out.println(" ------------------------------------");






    }
}
