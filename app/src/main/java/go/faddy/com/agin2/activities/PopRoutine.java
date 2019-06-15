package go.faddy.com.agin2.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.TextView;

import go.faddy.com.agin2.R;

public class PopRoutine extends Activity {
    TextView subject, teacher, time;
    String getSub, getTech, getTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_routine);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
//        getWindow().setLayout((int) (width * .8), (int) (height * .7));
//        int popupHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Bundle bundle = getIntent().getExtras();
        getTech = bundle.getString("teacher");
        getSub = bundle.getString("subject");
        getTime = bundle.getString("period");
        subject = findViewById(R.id.subject_name);
        teacher = findViewById(R.id.teachers_name);
        time = findViewById(R.id.time);
        subject.setText(getSub);
        teacher.setText(getTech);
        time.setText(getTime);

    }
}
