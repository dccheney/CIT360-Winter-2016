import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Carissa on 3/3/2016.
 */
public class JSONmovies implements Serializable {
    private String title;
    private String genre;
    private String rating;
    private Integer year;

    // default constructor
    public JSONmovies(){
    }

    public JSONmovies(String title, String genre, String rating, Integer year) {
        this.title  = title;
        this.genre  = genre;
        this.rating = rating;
        this.year   = year;
    }

    public JSONmovies(HashMap hashMap){
        this.title = (String)hashMap.get("title");
        this.genre = (String)hashMap.get("genre");
        this.rating = (String)hashMap.get("rating");
        Long asLong = (Long)hashMap.get("year");
        this.year = asLong.intValue();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONmovies that = (JSONmovies) o;

        if (!title.equals(that.title)) return false;
        if (!genre.equals(that.genre)) return false;
        if (!rating.equals(that.rating)) return false;
        return year.equals(that.year);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JSONmovies{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", year=" + year +
                '}';
    }
}
