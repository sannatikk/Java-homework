package exercises;

public class SMSNotification extends Notification implements Sendable {

    public SMSNotification(String recipient, String message){
        super(recipient, message);
    }

    @Override
    public String formatMessage(){

        // remove the first index of the string
        String modifiedRecipient = recipient.substring(1);
        modifiedRecipient = "+358-" + modifiedRecipient;
        return modifiedRecipient + ": " + message;
    }

    public String send(){
        String modifiedMessage = this.formatMessage();
        return "Sent SMS " + modifiedMessage;
    }

}
