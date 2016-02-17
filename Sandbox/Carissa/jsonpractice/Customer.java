package jsonpractice;

import java.io.Serializable;

/**
 * Created by Carissa on 2/2/2016.
 */
public class Customer implements Serializable{
    private String user;
    private long age;
    private String country;

    public Customer() {
        this.user = null;
        this.age = 0;
        this.country = null;
    }

    public Customer (String user, long age, String country) {
        this.user = user;
        this.age = age;
        this.country = country;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
