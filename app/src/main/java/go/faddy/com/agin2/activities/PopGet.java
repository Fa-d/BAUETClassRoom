package go.faddy.com.agin2.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import go.faddy.com.agin2.adapters.calenderPopGetAdapter;
import go.faddy.com.agin2.models.RetrivingDates;
import go.faddy.com.agin2.models.calenderPopGet;
import go.faddy.com.agin2.R;


public class PopGet extends Activity {
    private RecyclerView recyclerView;
    private List<calenderPopGet> popGet;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_get);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
//        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), ViewGroup.LayoutParams.WRAP_CONTENT);
        Bundle bundle = getIntent().getExtras();
        ArrayList<RetrivingDates> ct = bundle.getParcelableArrayList("ct");
        ArrayList<RetrivingDates> hw = bundle.getParcelableArrayList("hw");
        ArrayList<RetrivingDates> ass = bundle.getParcelableArrayList("ass");
        ArrayList<RetrivingDates> lab = bundle.getParcelableArrayList("lab");
        Long good = bundle.getLong("date");
        Date today = new Date(good);
        String day = (String) DateFormat.format("dd", today);
        String monthNumber = (String) DateFormat.format("MM", today);

        int i = 0, j = 0, k = 0, l = 0;

        popGet = new ArrayList<>();
        if (ct != null) {
            for (RetrivingDates dates : ct) {
                if (dates.getDay().equals(day) && dates.getMonth().equals(monthNumber)) {
                    calenderPopGet f = new calenderPopGet("Class Test", dates.getSubject());
                    Toast.makeText(this, "Got ct", Toast.LENGTH_SHORT).show();
                    popGet.add(f);
                    i++;
                }
            }
        } else {
            Toast.makeText(this, "CT is null", Toast.LENGTH_SHORT).show();
        }
        if (hw != null) {
            for (RetrivingDates dates : hw) {
                if (dates.getDay().equals(day) && dates.getMonth().equals(monthNumber)) {
                    calenderPopGet f = new calenderPopGet("Home Work", dates.getSubject());
                    Toast.makeText(this, "Got HW", Toast.LENGTH_SHORT).show();
                    popGet.add(f);
                    j++;
                }
            }
        } else {
            Toast.makeText(this, "HW is null", Toast.LENGTH_SHORT).show();
        }
        if (ass != null) {
            for (RetrivingDates dates : ass) {
                if (dates.getDay().equals(day) && dates.getMonth().equals(monthNumber)) {
                    calenderPopGet f = new calenderPopGet("Assignment", dates.getSubject());
                    Toast.makeText(this, "Got ASS", Toast.LENGTH_SHORT).show();
                    popGet.add(f);
                    k++;
                }
            }
        } else {
            Toast.makeText(this, "ASS is null", Toast.LENGTH_SHORT).show();
        }
        if (lab != null) {
            for (RetrivingDates dates : lab) {
                if (dates.getDay().equals(day) && dates.getMonth().equals(monthNumber)) {
                    calenderPopGet f = new calenderPopGet("Lab Report", dates.getSubject());
                    popGet.add(f);
                    Toast.makeText(this, "Got lab", Toast.LENGTH_SHORT).show();
                    l++;
                }
            }
        } else {
            Toast.makeText(this, "LAB is null", Toast.LENGTH_SHORT).show();
        }
        if (i == 0 && j == 0 && k == 0 && l == 0) {
            calenderPopGet f = new calenderPopGet("Nothing on that day", " \uD83D\uDE1C  \uD83D\uDE1C  \uD83D\uDE1C  \uD83D\uDE1C  \uD83D\uDE1C ");
            popGet.add(f);
        }
        recyclerView = findViewById(R.id.recycler_view_popget);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new calenderPopGetAdapter(popGet, this);
        recyclerView.setAdapter(adapter);
    }
}
