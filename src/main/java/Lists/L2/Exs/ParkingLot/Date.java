package Lists.L2.Exs.ParkingLot;

import java.util.Calendar;

public class Date {
    private final Calendar calendar = Calendar.getInstance();

    protected int day, month, year, hour, minute, second;

    public Date(){
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public Date(int hour, int minute, int second) {
        this();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Date(boolean realDate) {
        this();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    public String getDate() {
        return day + "/" + month + "/" + year+ " " + hour + ":" + minute + ":" + second;
    }

    int difference(Date other) {
        int totalSeconds1 = this.hour * 3600 + this.minute * 60 + this.second;
        int totalSeconds2 = other.hour * 3600 + other.minute * 60 + other.second;
        return Math.abs(totalSeconds1 - totalSeconds2);
    }

    public int getMonth() {
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }
}


