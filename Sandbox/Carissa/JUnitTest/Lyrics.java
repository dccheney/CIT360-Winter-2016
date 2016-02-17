package JUnitTest;

/**
 * Created by Carissa on 2/9/2016
.
        */
public class Lyrics {
    private String lyrics;

    public Lyrics() {
        lyrics = null;
    }

    public Lyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String printLyrics() {
        System.out.println(lyrics);
        return lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}