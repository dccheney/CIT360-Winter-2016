import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 * Created by brian on 3/5/16.
 */

@Entity
@Table(name = "person")
public class Person
{
    @Id
    @GeneratedValue
    private Integer person_id;
    private String  person_first_name;
    private String  person_last_name;

    public Person()
    {

    }

    public Person(Integer person_id, String person_first_name, String person_last_name)
    {
        this.person_id = person_id;
        this.person_first_name = person_first_name;
        this.person_last_name = person_last_name;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="check_out",
            joinColumns = { @JoinColumn( name="person_id") },
            inverseJoinColumns = @JoinColumn( name="book_id")
    )

    private Set<Book> books;



    @Override
    public String toString()
    {
        return "Person{" +
                "person_id=" + person_id +
                ", person_first_name='" + person_first_name + '\'' +
                ", person_last_name='" + person_last_name + '\'' +
                '}';
    }

    public Integer getPersonId()
    {
        return person_id;
    }

    public void setPersonId(Integer person_id)
    {
        this.person_id = person_id;
    }

    public String getPersonFirstName()
    {
        return person_first_name;
    }

    public void setPersonFirstName(String person_first_name)
    {
        this.person_first_name = person_first_name;
    }

    public String getPersonLastName()
    {
        return person_last_name;
    }

    public void setPersonLastName(String person_last_name)
    {
        this.person_last_name = person_last_name;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
}