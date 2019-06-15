package go.faddy.com.agin2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RetrivingDates implements Parcelable {
    String day, month, year, subject, description;
    public RetrivingDates() {
    }

    public RetrivingDates(String day, String month, String year, String subject, String description) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.subject = subject;
        this.description = description;
    }

    protected RetrivingDates(Parcel in) {
        day = in.readString();
        month = in.readString();
        year = in.readString();
        subject = in.readString();
        description = in.readString();
    }

    public static final Creator<RetrivingDates> CREATOR = new Creator<RetrivingDates>() {
        @Override
        public RetrivingDates createFromParcel(Parcel in) {
            return new RetrivingDates(in);
        }

        @Override
        public RetrivingDates[] newArray(int size) {
            return new RetrivingDates[size];
        }
    };

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(month);
        dest.writeString(year);
        dest.writeString(subject);
        dest.writeString(description);
    }
}
