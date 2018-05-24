package Exceptions;


/**
 * Exception for when there's a try to add an already existing email
 */
public class DuplicateMailException extends Exception {

    public DuplicateMailException(){
        super();
    }

    public String toString(){
        return "Mensagem duplicada.";
    }
}
