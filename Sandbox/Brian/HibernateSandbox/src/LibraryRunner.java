/**
 * Created by brian on 3/5/16.
 */
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.hibernate.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LibraryRunner
{
    private List<Person> persons;
    private LibraryConfig theLibraryConfigUtility;

    public LibraryRunner()
    {
        theLibraryConfigUtility = new LibraryConfig();
    }



    public static void main(String[] args)
    {
        LibraryRunner aLibraryRunnerInstance = new LibraryRunner();
        System.out.println("Before function call");
        aLibraryRunnerInstance.addNewPersons();
        aLibraryRunnerInstance.showAllPersons();
        aLibraryRunnerInstance.modifyPerson();
        aLibraryRunnerInstance.addSharedBook();
        System.out.println("Nasty Nulls");
        try
        {
            aLibraryRunnerInstance.addNulls();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Nasty Random String");
        try
        {
            aLibraryRunnerInstance.queryRandomString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Nasty SQL");
        try
        {
            aLibraryRunnerInstance.queryManualSql();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Nasty Empty String");
        try
        {
            aLibraryRunnerInstance.queryEmptyString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Nasty Delete");
        aLibraryRunnerInstance.deleteAddedPersons();

    }

    public void addNewPersons()
    {
        System.out.println("Got here");
        Session session = theLibraryConfigUtility.getCurrentSession();
        /*
         * all database interactions in Hibernate are required to be inside a transaction.
         */
        System.out.println("Got here2");
        Transaction transaction = session.beginTransaction();
        /*
         * create some Person instances.
         */
        System.out.println("Got here3");
        Person theFirstPerson = new Person();
        theFirstPerson.setPersonFirstName("John");
        theFirstPerson.setPersonLastName("Doe");

        System.out.println("Got here4");
        Person theSecondPerson = new Person();
        theSecondPerson.setPersonFirstName("Jane");
        theSecondPerson.setPersonLastName("Doe");

        /*
         * save each instance as a record in the database
         */
        System.out.println("Got here5");
        session.save(theFirstPerson);
        System.out.println("Got here6");
        session.save(theSecondPerson);
        transaction.commit();

        /*
         * prove that the Person instances were added to the database and that
         * the instances were each updated with a database generated id.
         */
        System.out.println("aUser generated ID is: " + theFirstPerson.getPersonId());
        System.out.println("anotherUser generated ID is: " + theSecondPerson.getPersonId());
    }

    /*
     * show how to get a collection of type List containing all of the records in the person table
     */
    public void showAllPersons()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * execute a HQL query against the database.  HQL is NOT SQL.  It is object based.
         */
        Query allPersonsQuery = session.createQuery("select p from Person as p order by p.person_id");
        /*
         * get a list of Book instances based on what was found in the database tables.
         */
        persons = allPersonsQuery.list();
        System.out.println("num: persons: " + persons.size());
        /*
         * iterate over each User instance returned by the query and found in the list.
         */
        Iterator<Person> iter = persons.iterator();
        while(iter.hasNext())
        {
            Person element = iter.next();
            System.out.println(element.toString());
            System.out.println("num of books: " + element.getBooks().size());
        }
        transaction.commit();
    }

    private void modifyPerson()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * get a single Person instance from the database.
         */
        Query singlePersonQuery = session.createQuery("select p from Person as p where p.person_first_name='John'");
        Person theFirstPerson = (Person)singlePersonQuery.uniqueResult();
        /*
         * change the Person first name for the Java instance
         */
        theFirstPerson.setPersonFirstName("Robert");
        /*
         * Call the session merge method for the Person instance in question.
         * This tells the database that the instance is ready to be permanently stored.
         */
        session.merge(theFirstPerson);
        /*
         * call the transaction commit method.  This tells the database that the changes are ready to be permanently stored.
         */
        transaction.commit();
        showAllPersons();
    }

    private void addSharedBook()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * get two Person instances from the database using HQL.  This is NOT SQL.  It is object based.
         */
        Query robertQuery = session.createQuery("select p from Person as p where p.person_first_name='Robert'");
        Person robertUser = (Person)robertQuery.uniqueResult();

        Query janeQuery = session.createQuery("select p from Person as p where p.person_first_name='Jane'");
        Person janeUser = (Person)janeQuery.uniqueResult();
        /*
         * create a PhoneNumber instance
         */
        Book sharedBook = new Book();
        sharedBook.setBookTitle("Animal Farm");
        sharedBook.setBookAuthor("George Orwell");

       /*
        * add the shared book to the Robert person
        */

        Set<Book> robertBooks = robertUser.getBooks();
        robertBooks.add(sharedBook);
       /*
        * set the book to be used by more than one Person
        */
        Set<Book> janesBooks = janeUser.getBooks();
        janesBooks.add(sharedBook);
       /*
        * inform the database that the phone number should be ready for permanent storage.
        */
        session.save(sharedBook);
       /*
        * inform the database that the modified Person instances should be ready for permanent storage.
        */
        session.merge(robertUser);
        session.merge(janeUser);
       /*
        * permanently store the changes into the database tables.
        */
        transaction.commit();
       /*
        * show that the database was updated by printing out all of the User instances created by a HQL query
        */
        showAllPersons();
    }

    private void deleteAddedPersons()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        int numPersons = persons.size();
        System.out.println("person count: " + numPersons);
        for (int i = 0; i < numPersons; i++)
        {
            System.out.println("deleting person " + persons.get(i).toString());
            //session.delete(persons.get(i));
        }
        transaction.commit();
        /*
          * at this point the records have been removed from the database but still exist in our class list attribute.
          * Do not store lists retrieved from the database since they will be out of synch with the database table from which they come.
          * This example shows that you should not store retrieved lists.
          */
        System.out.println(persons);
        persons.clear();
        /*
          * now the Java instances are also gone and the database is back to its original state so the example application can be run again.
          */
        System.out.println(persons);

    }

    public void addNulls()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            Query nullStringQuery = session.createQuery(null); // a blank empty string.
            persons = nullStringQuery.list();

            System.out.println(persons.toString());
            transaction.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void queryEmptyString()
    {

        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            /*
             * execute a HQL query against the database.  HQL is NOT SQL.  It is object based.
             */
            Query emptyStringQuery = session.createQuery(""); // a blank empty string.

            persons = emptyStringQuery.list();

            System.out.println(persons.toString());
            transaction.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public void queryRandomString()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            /*
             * execute a HQL query against the database.  HQL is NOT SQL.  It is object based.
             */
            Query randomStringQuery = session.createQuery("Hello World"); // a blank empty string.

            persons = randomStringQuery.list();

            System.out.println(persons.toString());
            transaction.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void queryManualSql()
    {
        Session session = theLibraryConfigUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            SQLQuery sqlQuery = session.createSQLQuery("select * FROM fantasyTable");

            persons = sqlQuery.list();

            System.out.println(persons.toString());
            transaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }





}
