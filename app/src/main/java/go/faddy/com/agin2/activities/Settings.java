package go.faddy.com.agin2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import go.faddy.com.agin2.R;
import go.faddy.com.agin2.models.Picasso_okhttp;

public class Settings extends AppCompatActivity {
    RadioGroup radioGroup, alarmTimes;
    RadioButton alarmYes, alarmNo, radioButton, radioAt6, radioAt7, radioAt8, radioAt9, radioAt10;
    LinearLayout times;
    Button go;
    public static int ALARM_PER, TIME_6 = 0 , TIME_7 = 0, TIME_8 = 0, TIME_9 = 0, TIME_10 = 0;
    private void initializeVariables() {
        radioGroup = findViewById(R.id.alarm_grp);
        alarmNo = findViewById(R.id.alarm_no);
        alarmYes = findViewById(R.id.alarm_yes);
        times = findViewById(R.id.alarm_times);
        alarmTimes = findViewById(R.id.alarm_time_grp);
        radioAt6 = findViewById(R.id.alarm_6);
        radioAt7 = findViewById(R.id.alarm_7);
        radioAt8 = findViewById(R.id.alarm_8);
        radioAt9 = findViewById(R.id.alarm_9);
        radioAt10 = findViewById(R.id.alarm_10);
        go = findViewById(R.id.good_to_go);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initializeVariables();
//        int radioId = radioGroup.getCheckedRadioButtonId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
                if(radioButton == alarmYes){
                    times.setVisibility(View.VISIBLE);
                    ALARM_PER = 1;
                }else if(radioButton == alarmNo){
                    ALARM_PER = 0;
                    times.setVisibility(View.GONE);
                }
            }
        });

        alarmTimes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
                if(radioButton == radioAt6){
                    TIME_6 = 1;  TIME_7 = 0; TIME_8 = 0; TIME_9 = 0; TIME_10 = 0;
                }else if(radioButton == radioAt7){
                    TIME_7 = 1;   TIME_6 = 0;  TIME_8 = 0; TIME_9 = 0; TIME_10 = 0;
                }else if(radioButton == radioAt8){
                    TIME_8 = 1;    TIME_6 = 0; TIME_7 = 0;   TIME_9 = 0; TIME_10 = 0;
                }else if(radioButton == radioAt9){
                    TIME_9 = 1;  TIME_6 = 0; TIME_7 = 0; TIME_8 = 0;  TIME_10 = 0;
                }else if(radioButton == radioAt10){
                    TIME_10 = 1;   TIME_6 = 0; TIME_7 = 0; TIME_8 = 0; TIME_9 = 0;
                }else{
                    TIME_6 = 0; TIME_7 = 0; TIME_8 = 0; TIME_9 = 0; TIME_10 = 0;
                }
            }
        });
        go.setOnClickListener(v -> {
            Picasso_okhttp alarm = new Picasso_okhttp();
            alarm.for_alarm();
            finish();
        });


        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
//        i.putExtra(AlarmClock.EXTRA_HOUR, hour);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Good Morning");
//        startActivity(i);
    }
}
