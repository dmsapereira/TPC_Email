package Mails;

import Exceptions.*;

import java.util.GregorianCalendar;
import java.util.Iterator;

public interface MailManagement {

    /**
     * Sends a message
     * @param subject message's subject
     * @param email message's receiver's email
     * @param body message's body
     * @param year date sent year
     * @param month date sent month
     * @param day date sent day
     * @throws DuplicateMailException when there's an attempt at sending an already sent email (date, subject, receiver's email)
     */
    void sendMessage(String subject, String email, String body, String year, String month, String day) throws DuplicateMailException;

    /**
     * Receives a message
     * @param subject message's subject
     * @param email message's sender's email
     * @param body message's body
     * @param year date sent year
     * @param month date sent month
     * @param day date sent day
     * @throws DuplicateMailException when there's an attempt at receiving an email that's already been received (date, subject, receiver's email)
     */
    void receiveMessage(String subject, String email, String body,  String year, String month, String day) throws DuplicateMailException;

    /**
     * Returns an Iterator for the messages that have been sent
     * @return Sent message's iterator
     */
    Iterator<SentMail> getSentMails();

    /**
     * Returns an Iterator for the messages that have been received
     * @return Received message's iterator
     */
    Iterator<ReceivedMail> getReceivedMails();

    /**
     * Returns an Iterator for a Set that only contains the messages with the subject
     * @param subject subject to filter messages for
     * @return Iterator for the filtered set
     * @throws NullSubjectException no emails have been found with the specified subject
     */
    Iterator<Mail> getWithSubject(String subject) throws NullSubjectException;

    /**
     * Returns an Iterator for a Set that only contains the messages that have been exchanged with the specified email
     * @param email email to filter messages for
     * @return Iterator for the filtered set
     * @throws NullEmailException no emails have been exchanged with the specified email
     */
    Iterator<Mail> getWithEmail(String email) throws NullEmailException;

    /**
     * Returns an Iterator for a Set that contains all the message's subjects
     * @return Iterator for the Set of subjects
     */
    Iterator<Mail> getSubjects();


}
