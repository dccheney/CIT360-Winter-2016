/**
 * Created by Carissa on 2/2/2016.
 */
public class Time implements Comparable{
    int hour;
    int minute;


    public Time () {
        this.hour   = 0;
        this.minute = 0;
    }

    public Time (int hour, int minute) {
        this.hour   = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public int compareTo(Object o) {
        // compare times
        Time time = (Time) o;
        if(minute > this.minute && hour > this.hour) {
            return -1;
        }
        else if (this.equals(time)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (hour != time.hour) return false;
        return minute == time.minute;

    }

    @Override
    public int hashCode() {
        int result = hour;
        result = 31 * result + minute;
        return result;
    }
}
