package go.faddy.com.agin2;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;

import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFrag extends Fragment implements OnSelectDateListener {

    RadioGroup radioGroup;
    RadioButton radioButton, getRadio, postRadio;


    public CalenderFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_calender, container, false);
        CalendarView calendarView = v.findViewById(R.id.calendarview);
        radioGroup = v.findViewById(R.id.radiogroup);



        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
//                Snackbar.make(getView(), eventDay.getCalendar().getTime().toString() +
//                        eventDay.isEnabled(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = v.findViewById(radioId);
                getRadio = v.findViewById(R.id.get);
                postRadio = v.findViewById(R.id.post);
                if(radioButton == getRadio){
                    Snackbar.make(getView(), "Get Selected", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else if(radioButton == postRadio){
                    startActivity(new Intent(getContext(), Pop.class));

                    Snackbar.make(getView(), "Post Selected", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
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
