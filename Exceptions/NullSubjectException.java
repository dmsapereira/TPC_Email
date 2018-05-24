package Exceptions;

/**
 * Exception for when there's an attempt at iterating the messages who contain a non existent subject
 */
public class NullSubjectException extends Exception {
    public NullSubjectException(){
        super();
    }

    public String toString(){
        return "Nao existem mensagens trocadas com esse assunto.";
    }
}
