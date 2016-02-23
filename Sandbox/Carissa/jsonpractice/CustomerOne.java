package jsonpractice;

import java.io.Serializable;

/**
 * Created by Carissa on 2/3/2016.
 */
public class CustomerOne implements Serializable{
    private String user;
    private long age;
    private String country;
    private Item item;

    public CustomerOne() {
        this.user = null;
        this.age = 0;
        this.country = null;
        this.item = null;
    }

    public CustomerOne (String user, long age, String country, Item item) {
        this.user = user;
        this.age = age;
        this.country = country;
        this.item = item;
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

    public void setAge(long age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
