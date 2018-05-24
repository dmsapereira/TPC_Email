package Mails;

import java.util.Comparator;

/**
 * Comparator to be used in a TreeSet which makes that TreeSet's elements be sorted by subject, instead of their natural order
 */
public class CompareBySubject implements Comparator<Mail> {

    /**
     * Compares the subjects of two messages
     * @param mail1 First message
     * @param mail2 Second message
     * @return Positive integer if <code>mail1</code>'s subject is greater than <code>mail2</code>, Negative integer if otherwise and 0 if they're equal
     */
    @Override
    public int compare(Mail mail1, Mail mail2) {
        return mail1.getSubject().compareTo(mail2.getSubject());
    }
}
