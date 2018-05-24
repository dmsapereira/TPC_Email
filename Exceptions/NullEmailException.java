package Exceptions;

/**
 * Exception for when there's an attempt of iterating the messages of an empty email
 */
public class NullEmailException extends Exception {

    public NullEmailException() {
        super();
    }

    public String toString() {
        return "Nao existem mensagens trocadas com esse email.";
    }
}
