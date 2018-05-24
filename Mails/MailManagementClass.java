package Mails;

import Exceptions.DuplicateMailException;
import Exceptions.NullEmailException;
import Exceptions.NullSubjectException;

import java.util.*;

public class MailManagementClass implements MailManagement {
    private Set<Mail> allMail; //contains all the mail, regardless of being sent or received
    private Set<SentMail> sentMails; //contains sent mail
    private Set<ReceivedMail> receivedMails;//contains received mail

    public MailManagementClass(){
        allMail=new LinkedHashSet<>();
        sentMails=new TreeSet<>();//TreeSet is used to facilitate sorting for the required iteration in getSent
        receivedMails=new TreeSet<>();//TreeSet is used to facilitate sorting in the required iteration in getReceived

    }


    @Override
    public void sendMessage(String subject, String email, String body, String year, String month, String day) throws DuplicateMailException {
        SentMail newMail=new SentMail(subject,email,body,year,month,day);
            if (allMail.contains(newMail))
                throw new DuplicateMailException();
            else{
                allMail.add(newMail);
                sentMails.add(newMail);
            }
    }

    @Override
    public void receiveMessage(String subject, String email, String body,String year, String month, String day) throws DuplicateMailException {
        ReceivedMail newMail=new ReceivedMail(subject,email,body,year,month,day);
        if (allMail.contains(newMail))
            throw new DuplicateMailException();
        else{
            allMail.add(newMail);
            receivedMails.add(newMail);
        }
    }

    @Override
    public Iterator<SentMail> getSentMails() {
        return sentMails.iterator();
    }

    @Override
    public Iterator<ReceivedMail> getReceivedMails() {
        return receivedMails.iterator();
    }

    @Override
    public Iterator<Mail> getWithSubject(String subject) throws NullSubjectException {
        Set<Mail> mails=new LinkedHashSet<>();
        for(Mail mail: allMail){
            if(mail.getSubject().equals(subject))
                mails.add(mail);
        }
        if(mails.isEmpty())
            throw new NullSubjectException();
        return mails.iterator();
    }

    @Override
    public Iterator<Mail> getWithEmail(String email) throws NullEmailException {
        Set<Mail> mails=new LinkedHashSet<>();
        for(Mail mail: allMail){
            if(mail.getEmail().equals(email))
                mails.add(mail);
        }
        if(mails.isEmpty())
            throw new NullEmailException();
        return mails.iterator();
    }

    @Override
    public Iterator<Mail> getSubjects() {
        Set<Mail> mails=new TreeSet<>(new CompareBySubject());
        mails.addAll(allMail);
        return mails.iterator();
    }
}
