package Mails;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public interface Mail {


    /**
     * Returns the message's subject
     * @return message subject
     */
    String getSubject();

    /**
     * Returns the message's body
     * @return message body
     */
    String getBody();

    /**
     * Returns the message's date
     * @return message date
     */
    LocalDate getDate();

    /**
     * Returns the message's date's year
     * @return message's date's year
     */
    String getYear();

    /**
     * Return the message's date's month
     * @return message's date's month
     */
    String getMonth();

    /**
     * Returns the message's date's day
     * @return message's date's day
     */
    String getDay();

    /**
     * Return the message's associated email, be that sender or receiver, depending on the message type
     * @return email associated to the message
     */
    String getEmail();



}
