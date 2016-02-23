package jsonpractice;

import java.io.Serializable;

/**
 * Created by Carissa on 2/3/2016.
 */
public class Item implements Serializable{
    private String product;
    private long amount;

    public Item() {
        this.product = null;
        this.amount = 0;
    }
    public Item(String product, long amount) {
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
