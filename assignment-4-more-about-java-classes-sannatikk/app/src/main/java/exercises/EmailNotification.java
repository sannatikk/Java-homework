package exercises;

public class EmailNotification extends Notification implements Sendable {

    public EmailNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public String formatMessage(){
        return recipient + ": " + message;
    }

    public String send(){
        return "Sent email " + recipient + ": " + message;
    }   

}
