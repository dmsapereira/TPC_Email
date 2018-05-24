package Mails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.Objects;

public class AbsMail implements Mail, Comparable<AbsMail> {
    private String email, subject, body,year,month,day;

    public AbsMail(String subject, String email, String body, String year, String month, String day){
        this.subject=subject;
        this.email=email;
        this.body=body;
        this.year=year;
        this.month=month;
        this.day=day;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public String getMonth() {
        return month;
    }

    @Override
    public String getDay() {
        return day;
    }

    /**
     * Changes the message's natural ordering to make them be sorted by date, then subject, then associated email
     * @param mail Message to compare to
     * @return Positive integer if current is greater than target, 0 if equal, Negative integer if current is less than target
     */
    @Override
    public int compareTo(AbsMail mail) {
        if(!this.getDate().equals(mail.getDate()))
            return this.getDate().compareTo(mail.getDate());
        if (!this.subject.equals(mail.getSubject()))
            return subject.compareTo(mail.getSubject());
        return this.email.compareTo(mail.getEmail());
    }

    /**
     * Changes the message's comparison parameters to only compare the unique identifiers (date,subject,email)
     * @param o Message to compare to
     * @return <code>true</code> if they're equal, <code>false</code> if they're not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsMail absMail = (AbsMail) o;
        return Objects.equals(email, absMail.email) &&
                Objects.equals(subject, absMail.subject) &&
                Objects.equals(year, absMail.year) &&
                Objects.equals(month, absMail.month) &&
                Objects.equals(day, absMail.day);
    }

    /**
     * Changes the hash to only take into account the unique identifiers (date,subject,email)
     * @return <code>hash</code>
     */
    @Override
    public int hashCode() {

        return Objects.hash(email, subject, year, month, day);
    }
}
