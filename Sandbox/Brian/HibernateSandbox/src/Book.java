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
@Table(name = "books")
public class Book
{

    @Id
    @GeneratedValue
    private Integer book_id;
    private String book_title;
    private String book_author;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
                name="check_out",
                joinColumns = { @JoinColumn( name="book_id") },
                inverseJoinColumns = @JoinColumn( name="person_id")
                )

    private Set<Person> persons;

    public Book()
    {

    }


    public Book(String book_title, String book_author)
    {
        this.book_title = book_title;
        this.book_author = book_author;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "book_id=" + book_id +
                ", book_title='" + book_title + '\'' +
                ", book_author='" + book_author + '\'' +
                '}';
    }

    public Integer getBookId()
    {
        return book_id;
    }

    public void setBookId(Integer book_id)
    {
        this.book_id = book_id;
    }

    public String getBookTitle()
    {
        return book_title;
    }

    public void setBookTitle(String book_title)
    {
        this.book_title = book_title;
    }

    public String getBookAuthor()
    {
        return book_author;
    }

    public void setBookAuthor(String book_author)
    {
        this.book_author = book_author;
    }

    public Set<Person> getPersons()
    {
        return persons;
    }

    public void setPersons(Set<Person> persons)
    {
        this.persons = persons;
    }
}
