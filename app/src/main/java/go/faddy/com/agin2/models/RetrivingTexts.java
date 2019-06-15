package go.faddy.com.agin2.models;

import java.util.ArrayList;

public class RetrivingTexts {
    private String description;
    private String subject;
    private String day;
    private String month;
    private String year;
    private String time_stamp;
    private ArrayList<RetrivingImageUrls> arrayList;

    public RetrivingTexts() {

    }

    public RetrivingTexts(String description, String subject, String day, String month, String year,
                          String time_stamp, ArrayList<RetrivingImageUrls> arrayList) {
        this.description = description;
        this.subject = subject;
        this.day = day;
        this.month = month;
        this.year = year;
        this.time_stamp = time_stamp;
        this.arrayList = arrayList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public ArrayList<RetrivingImageUrls> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<RetrivingImageUrls> arrayList) {
        this.arrayList = arrayList;
    }
}

