package go.faddy.com.agin2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import go.faddy.com.agin2.activities.PopGet;
import go.faddy.com.agin2.activities.PopPost;
import go.faddy.com.agin2.models.RetrivingDates;
import go.faddy.com.agin2.R;
import go.faddy.com.agin2.utils.DrawableUtils;

import static android.content.Context.VIBRATOR_SERVICE;
import static go.faddy.com.agin2.activities.Settings.ALARM_PER;
import static go.faddy.com.agin2.activities.Settings.TIME_6;
import static go.faddy.com.agin2.activities.Settings.TIME_7;
import static go.faddy.com.agin2.activities.Settings.TIME_8;
import static go.faddy.com.agin2.activities.Settings.TIME_9;
import static go.faddy.com.agin2.activities.Settings.TIME_10;

public class CalenderFrag extends Fragment implements OnSelectDateListener {
    public static String STRING_EXTRA = "CAL";
    RadioGroup radioGroup;
    RadioButton radioButton, getRadio, postRadio;
    public int day, month, year;
    public String day_, month_, year_;
    CalendarView calendarView;
    Intent intent;
    public Vibrator vi;
    public ArrayList<RetrivingDates> retrivingDatesCT = new ArrayList<>(), retrivingDatesAss = new ArrayList<>(),
            retrivingDatesHW = new ArrayList<>(), retrivingDatesLR = new ArrayList<>();
    public List<EventDay> events;

    public CalenderFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calender, container, false);
        vi = (Vibrator) Objects.requireNonNull(getContext()).getSystemService(VIBRATOR_SERVICE);
        getFirebaseObjects();
        calendarView = v.findViewById(R.id.calendarview);
        radioGroup = v.findViewById(R.id.radiogroup);
        events = new ArrayList<>();

        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                getFirebaseObjects();
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = v.findViewById(radioId);
                getRadio = v.findViewById(R.id.get);
                postRadio = v.findViewById(R.id.post);

                if (radioButton == getRadio) {
                    Intent intent = new Intent(getActivity(), PopGet.class);
                    intent.putParcelableArrayListExtra("ct", retrivingDatesCT);
                    intent.putParcelableArrayListExtra("ass", retrivingDatesAss);
                    intent.putParcelableArrayListExtra("lab", retrivingDatesLR);
                    intent.putParcelableArrayListExtra("hw", retrivingDatesHW);
                    Date y = eventDay.getCalendar().getTime();
                    intent.putExtra("date", y.getTime());
                    startActivity(intent);
                } else if (radioButton == postRadio) {
                    intent = new Intent(getActivity().getApplicationContext(), PopPost.class);
                    Date y = eventDay.getCalendar().getTime();
                    intent.putExtra(STRING_EXTRA, y.getTime());
                    Snackbar.make(getView(), "Post an update", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "Some error happend", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        return v;
    }

    private void getFirebaseObjects() {
        DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference().child("posts").child("type");

        //for retriving classtest dates
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                retrivingDatesCT.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    vi.vibrate(200);
                    RetrivingDates re = dataSnapshot1.getValue(RetrivingDates.class);
                    retrivingDatesCT.add(re);
                }
                for (int i = 0; i < retrivingDatesCT.size(); i++) {
                    String month = retrivingDatesCT.get(i).getMonth();
                    String day = retrivingDatesCT.get(i).getDay();
                    String year = retrivingDatesCT.get(i).getYear();
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.MONTH, Integer.valueOf(month)-1);
                    calendar1.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
                    try {
                        events.add(new EventDay(calendar1, DrawableUtils.getCircleDrawableWithText(getContext(), "CT")));
                    } catch (Exception e) {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    calendarView.setEvents(events);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dataRef.child("class_test").addListenerForSingleValueEvent(eventListener);

        //for retriving homework dates
        dataRef.child("home_work").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                retrivingDatesHW.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    RetrivingDates re = dataSnapshot1.getValue(RetrivingDates.class);
                    retrivingDatesHW.add(re);
                }
                for (int i = 0; i < retrivingDatesHW.size(); i++) {
                    String month = retrivingDatesHW.get(i).getMonth();
                    String day = retrivingDatesHW.get(i).getDay();
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.MONTH, Integer.valueOf(month) -1);
                    calendar1.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day) );
                    try {
                        events.add(new EventDay(calendar1, DrawableUtils.getCircleDrawableWithText(getContext(), "HW")));
                    } catch (Exception e) {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
//                    calendarView.setEvents(events);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        //retriving assignment dates
        dataRef.child("assignment").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                retrivingDatesAss.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    RetrivingDates re = dataSnapshot1.getValue(RetrivingDates.class);
                    retrivingDatesAss.add(re);
                }
                for (int i = 0; i < retrivingDatesAss.size(); i++) {
                    String month = retrivingDatesAss.get(i).getMonth();
                    String day = retrivingDatesAss.get(i).getDay();
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.MONTH, Integer.valueOf(month)-1);
                    calendar1.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
                    try {
                        events.add(new EventDay(calendar1, DrawableUtils.getCircleDrawableWithText(getContext(), "ASS")));
                    } catch (Exception e) {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
//                    calendarView.setEvents(events);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        //retriving labreport dates
        dataRef.child("lab_report").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                retrivingDatesLR.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    RetrivingDates re = dataSnapshot1.getValue(RetrivingDates.class);
                    retrivingDatesLR.add(re);
                }
                for (int i = 0; i < retrivingDatesLR.size(); i++) {
                    String month = retrivingDatesLR.get(i).getMonth();
                    String day = retrivingDatesLR.get(i).getDay();
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.MONTH, Integer.valueOf(month)-1);
                    calendar1.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
                    try {
                        events.add(new EventDay(calendar1, DrawableUtils.getCircleDrawableWithText(getContext(), "LR")));
                    } catch (Exception e) {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    calendarView.setEvents(events);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        setAlarm();
    }

    private void setAlarm() {

    }

    @Override
    public void onSelect(List<Calendar> calendar) {

    }
}
