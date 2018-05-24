import Exceptions.DuplicateMailException;
import Exceptions.NullEmailException;
import Exceptions.NullSubjectException;
import Mails.*;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 52886: Bruno Ramos; 52890: David Pereira         FCT     MIEI    2017/18     POO
 *
 */
public class Main {

    private static final String SUCCESSFUL_MAIL = "Mensagem registada.";
    private static final String EXIT_MESSAGE="A terminar.";
    private static final String FORMAT_LIST = "%s-%s-%s | %s | %s\n";//facilitates output
    private static final String FORMAT_LIST_SELECTIVE="%s-%s-%s | %s | %s | %s\n";//facilitates output

    /**
     * Command enum to facilitate input and for command readability
     */
    enum Command {
        ENVIAR, RECEBER, ENVIADAS, RECEBIDAS, ASSUNTO, EMAIL, ASSUNTOS, SAIR
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MailManagement manager = new MailManagementClass();
        processCommand(in, manager);
        System.out.println(EXIT_MESSAGE);
        in.close();
    }

    /**
     * Contains the command loop, which is only broken if the command read is the exit command
     */
    private static void processCommand(Scanner in, MailManagement manager) {
        Command option = getCommand(in);
        while (!option.equals(Command.SAIR)) {
            executeCommand(option, in, manager);
            System.out.println();
            option=getCommand(in);
        }
    }

    /**
     * Does the selecting of the command and calls the associated method from MailManagement
     * @param option command received from getCommand
     */
    private static void executeCommand(Command option, Scanner in, MailManagement manager) {
        switch (option) {
            case ENVIAR:
                sendCommand(in, manager);
                break;
            case RECEBER:
                receiveCommand(in, manager);
                break;
            case ENVIADAS:
                sentCommand(in, manager);
                break;
            case RECEBIDAS:
                receivedCommand(manager);
                break;
            case ASSUNTO:
                subjectCommand(in, manager);
                break;
            case EMAIL:
                emailCommand(in,manager);
                break;
            case ASSUNTOS:
                subjectsCommand(manager);
                break;
            case SAIR:
                break;
        }
    }

    /**
     * Executes the ASSUNTOS command
     */
    private static void subjectsCommand(MailManagement manager) {
        Mail current;
        Iterator<Mail> itera=manager.getSubjects();
        while(itera.hasNext()){
            current=itera.next();
            System.out.println(current.getSubject());
        }
    }

    /**
     * Executes the EMAIL command
     */
    private static void emailCommand(Scanner in, MailManagement manager) {
        String email = in.nextLine();
        try {
            Iterator<Mail> itera = manager.getWithEmail(email);
            Mail current;
            System.out.println("data | assunto | email | texto");
            while (itera.hasNext()) {
                current = itera.next();
                System.out.printf(FORMAT_LIST_SELECTIVE, current.getYear(), current.getMonth(), current.getDay(), current.getSubject(), current.getEmail(),current.getBody());
            }
        } catch (NullEmailException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the ASSUNTO command
     */
    private static void subjectCommand(Scanner in, MailManagement manager) {
        String subject = in.nextLine();
        try {
            Iterator<Mail> itera = manager.getWithSubject(subject);
            Mail current;
            System.out.println("data | assunto | email | texto");
            while (itera.hasNext()) {
                current = itera.next();
                System.out.printf(FORMAT_LIST_SELECTIVE, current.getYear(), current.getMonth(), current.getDay(), current.getSubject(), current.getEmail(),current.getBody());
            }
        } catch (NullSubjectException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the RECEBIDAS command
     */
    private static void receivedCommand(MailManagement manager) {
        Iterator<ReceivedMail> itera = manager.getReceivedMails();
        ReceivedMail current;
        System.out.println("data | assunto | email");

        while (itera.hasNext()) {
            current = itera.next();
            System.out.printf(FORMAT_LIST, current.getYear(), current.getMonth(), current.getDay(), current.getSubject(), current.getEmail());
        }
    }

    /**
     * Executes the ENVIADAS command
     */
    private static void sentCommand(Scanner in, MailManagement manager) {
        Iterator<SentMail> itera = manager.getSentMails();
        SentMail current;
        System.out.println("data | assunto | email");
        while (itera.hasNext()) {
            current = itera.next();
            System.out.printf(FORMAT_LIST, current.getYear(), current.getMonth(), current.getDay(), current.getSubject(), current.getEmail());
        }
    }

    /**
     * Executes the RECEBER command
     */
    private static void receiveCommand(Scanner in, MailManagement manager) {
        String subject, email, body, date;
        subject = in.nextLine();
        email = in.nextLine();
        body = in.nextLine();
        date = in.nextLine();
        try {
            manager.receiveMessage(subject, email, body,date.substring(0,4),date.substring(5,7),date.substring(8,10));
            System.out.println(SUCCESSFUL_MAIL);
        } catch (DuplicateMailException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the ENVIAR command
     */
    private static void sendCommand(Scanner in, MailManagement manager) {
        String subject, email, body, date;
        subject = in.nextLine();
        email = in.nextLine();
        body = in.nextLine();
        date = in.nextLine();
        try {
            manager.sendMessage(subject, email, body, date.substring(0,4), date.substring(5,7),date.substring(8,10));
            System.out.println(SUCCESSFUL_MAIL);
        } catch (DuplicateMailException e) {
            System.out.println(e);
        }
    }

    /**
     * Reads the user's input and returns the associated Command enum
     * @return read command
     */
    private static Command getCommand(Scanner in) {
        String command = in.nextLine().toUpperCase();
        return Command.valueOf(command);
    }
}
