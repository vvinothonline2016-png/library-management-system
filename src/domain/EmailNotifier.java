package domain;

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(Patron patron, String message){
        System.out.println("Sending email to " + patron.getName() + " (" + patron.getContactInfo() + "): " + message);
    }

}
