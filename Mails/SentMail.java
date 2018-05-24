package Mails;

/**
 * Serves only to diferentiate received messages from sent ones. Does nothing more than AbsMail. Represents received messages.
 */
public class SentMail extends AbsMail {

    public SentMail(String subject, String email, String body, String year, String month, String day){
        super(subject,email,body,year,month,day);
    }
}
