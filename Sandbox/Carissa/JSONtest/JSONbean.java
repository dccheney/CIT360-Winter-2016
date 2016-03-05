package JSONtest;

/**
 * Created by Carissa on 3/3/2016.
 */
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by newuser on 1/28/16.
 */
public class JSONbean implements Serializable{
    private String make;
    private String model;
    private Integer year;
    private String color;

    public JSONbean(){

    }

    public JSONbean(String make, String model, Integer year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public JSONbean(HashMap ahashMap){
        this.make = (String) ahashMap.get("make");
        this.model = (String) ahashMap.get("model");
        Long asLong = (Long)ahashMap.get("year");
        this.year= asLong.intValue();
        this.color = (String) ahashMap.get("color");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONbean jsoNbean = (JSONbean) o;

        if (make != null ? !make.equals(jsoNbean.make) : jsoNbean.make != null) return false;
        if (model != null ? !model.equals(jsoNbean.model) : jsoNbean.model != null) return false;
        if (year != null ? !year.equals(jsoNbean.year) : jsoNbean.year != null) return false;
        return color != null ? color.equals(jsoNbean.color) : jsoNbean.color == null;

    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
