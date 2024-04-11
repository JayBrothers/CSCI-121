public class Date {
    int month, day, year, time;

    public Date(int month, int day, int year, int time) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.time = time;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }
}

