package go.faddy.com.agin2.Fragments;


import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import go.faddy.com.agin2.Pop;
import go.faddy.com.agin2.R;
import go.faddy.com.agin2.utils.DrawableUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFrag extends Fragment implements OnSelectDateListener {
    public static String STRING_EXTRA = "CAL";
    RadioGroup radioGroup;
    RadioButton radioButton, getRadio, postRadio;
    public int day, month, year;
    public String day_, month_, year_;
    CalendarView calendarView;
    Intent intent;

    public CalenderFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_calender, container, false);
        CalendarView calendarView = v.findViewById(R.id.calendarview);
        radioGroup = v.findViewById(R.id.radiogroup);


        List<EventDay> events = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//
//        events.add(new EventDay(calendar, DrawableUtils.getCircleDrawableWithText(getContext(), "CT")));
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_MONTH, 0);
        events.add(new EventDay(calendar1, DrawableUtils.getCircleDrawableWithText(getContext(), "ASS")));
        calendarView.setEvents(events);
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
//                Snackbar.make(getView(), eventDay.getCalendar().getTime().toString() +
//                        eventDay.isEnabled(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                intent = new Intent(getActivity().getApplicationContext(), Pop.class);

                Date y = eventDay.getCalendar().getTime();
//                Toast.makeText(getContext(), r , Toast.LENGTH_SHORT).show();
                intent.putExtra(STRING_EXTRA, y.getTime());

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = v.findViewById(radioId);
                getRadio = v.findViewById(R.id.get);
                postRadio = v.findViewById(R.id.post);
                if (radioButton == getRadio) {
                    day = eventDay.getCalendar().getTime().getDate();
                    day_ = String.valueOf(day);
                    month = eventDay.getCalendar().getTime().getMonth();
                    String month_ = String.valueOf(month + 1);
                    year = eventDay.getCalendar().getTime().getYear();
                    year_ = String.valueOf(year - 100);
                    Toast.makeText(getContext(), day + "\n" + month_ + "\n" + year_, Toast.LENGTH_SHORT).show();

//                    Snackbar.make(getView(), (int) d, Snackbar.LENGTH_LONG)
//                           .setAction("Action", null).show();
                } else if (radioButton == postRadio) {
                    day = eventDay.getCalendar().getTime().getDate();
                    month = eventDay.getCalendar().getTime().getMonth();
                    year = eventDay.getCalendar().getTime().getYear();
                    day_ = String.valueOf(day);
                    month_ = String.valueOf(month + 1);
                    year_ = String.valueOf(year - 100);

                    startActivity(intent);

                    Snackbar.make(getView(), "Post Selected", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(getView(), "Some error happend", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        return v;
    }

//    public void cheakButton(View v){
//        int radioId = radioGroup.getCheckedRadioButtonId();
//        radioButton = v.findViewById(radioId);
//    }

    @Override
    public void onSelect(List<Calendar> calendar) {

    }
}
