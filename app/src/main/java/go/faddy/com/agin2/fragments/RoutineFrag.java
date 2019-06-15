package go.faddy.com.agin2.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import go.faddy.com.agin2.activities.PopRoutine;
import go.faddy.com.agin2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoutineFrag extends Fragment {
    Button sun_1st,sun_2nd, sun_3rd, sun_4th, sun_5th, mon_1st,
            mon_2nd, mon_3rd, mon_4th,
            tue_1st, tue_2nd,
            wed_1st, wed_2nd, wed_3rd, wed_4th, tea_break,
            thu_1st, thu_2nd, thu_3rd, thu_4th, thu_5th, thu_6th;
    String sun_1st_code,sun_2nd_code, sun_3rd_code, sun_4th_code, sun_5th_code, mon_1st_code,
            mon_2nd_code, mon_3rd_code, mon_4th_code,
            tue_1st_code, tue_2nd_code,
            wed_1st_code, wed_2nd_code, wed_3rd_code, wed_4th_code,
            thu_1st_code, thu_2nd_code, thu_3rd_code, thu_4th_code, thu_5th_code, thu_6th_code, tea_break_name;
    public String subName;
    public String teacherName;
    String fst_period = "08:15 AM - 09:10 AM", snd_period = "09:15 AM - 10:10 AM", thrd_period = "10:15 AM - 11:10 AM",
            frth_peiod = "11:30 AM - 12:25 AM", fifth_period = "12:30 AM - 01:25 AM", sixth_period = "01:30 AM - 02:25AM";
    Intent intent;
    public RoutineFrag() {
        // Required empty public constructor
        ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_routine, container, false);
        inttilizingValueAndVariables(v);

//        Intent intent = new Intent(getContext(), PopRoutine.class);
        intent = new Intent(getActivity(), PopRoutine.class);
//        v.findViewById(R.id.sun_1st).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("period", fst_period);
//                OpeningIntent(sun_1st_code);
//            }
//        });
        sun_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", snd_period);
                OpeningIntent(sun_2nd_code);
            }
        });

        sun_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", thrd_period);
                OpeningIntent(sun_3rd_code);
            }
        });

        sun_4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", frth_peiod);
                OpeningIntent(sun_4th_code);
            }
        });

        sun_5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", fifth_period);
                OpeningIntent(sun_5th_code);
            }
        });

        mon_1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", fst_period);
                OpeningIntent(mon_1st_code);
            }
        });
        mon_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", snd_period);
                OpeningIntent(mon_2nd_code);
            }
        });
        mon_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", thrd_period);
                OpeningIntent(mon_3rd_code);
            }
        });
        mon_4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", "12:30 AM - 03:30 PM");
                OpeningIntent(mon_4th_code);
            }
        });
        tue_1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", "08:15 AM - 11:10 AM");
                OpeningIntent(tue_1st_code);
            }
        });
        tue_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", "11:30 AM - 02:25 PM");
                OpeningIntent(tue_2nd_code);
            }
        });
//        wed_1st.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("period", fst_period);
//                OpeningIntent(wed_1st_code);
//            }
//        });
        wed_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", snd_period);
                OpeningIntent(wed_2nd_code);
            }
        });
        wed_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", thrd_period);
                OpeningIntent(wed_3rd_code);
            }
        });
        wed_4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", "11:30 AM - 02:25 AM");
                OpeningIntent(wed_4th_code);
            }
        });
        thu_1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", fst_period);
                OpeningIntent(thu_1st_code);
            }
        });
        thu_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", snd_period);
                OpeningIntent(thu_2nd_code);
            }
        });
        thu_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", thrd_period);
                OpeningIntent(thu_3rd_code);
            }
        });
        thu_4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", frth_peiod);
                OpeningIntent(thu_4th_code);
            }
        });
        thu_5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", fifth_period);
                OpeningIntent(thu_5th_code);
            }
        });
        thu_6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", sixth_period);
                OpeningIntent(thu_6th_code);
            }
        });
        tea_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("period", "11:10 AM - 11:30 AM");
                OpeningIntent(tea_break_name);
            }
        });
        return v;
    }

    private void OpeningIntent(String s) {
        switch (s) {
            case "CSE 3101":
                subName = "Database Management System";
                teacherName = "MD. Omar Faruk";
                openIntent();
                break;
            case "CSE 3102":
                subName = "Database Management System (Sessional)";
                teacherName = "MD. Omar Faruk or MD. Moktar Hossain";
                openIntent();
                break;
            case "CSE 3103":
                subName = "Compiler";
                teacherName = "MD. Al-Amin";
                openIntent();
                break;
            case "CSE 3104":
                subName = "Compiler (Sessional)";
                teacherName = "MD. Al-Amin or MD. Alamin";
                openIntent();
                break;
            case "CSE 3105":
                subName = "Microprocessor and microcontroller";
                teacherName = "MD. Sabbir Ejaz";
                openIntent();
                break;
            case "CSE 3106":
                subName = "Microprocessor and microcontroller (Sessional)";
                teacherName = "MD. Sabbir Ejaz";
                openIntent();
                break;
            case "CSE 3107":
                subName = "Theory of computation";
                teacherName = "MD. Al-Amin";
                openIntent();
                break;
            case "CSE 3108":
                subName = "Theory of computation";
                teacherName = "MSM or Ahmed Salman Tariq";
                openIntent();
                break;
            case "CSE 3109":
                subName = "Computer Network";
                teacherName = "Mithun Kumar";
                openIntent();
                break;
            case "CSE 3110":
                subName = "Computer Network (Sessional)";
                teacherName = "Mithun Kumar or MD. Golam Sarwar Bhuiyan";
                openIntent();
                break;
            case "TEA BREAK":
                subName = "Tea Break";
                teacherName = "Have a smoke ";
                openIntent();
                break;
            default:
                Toast.makeText(getContext(), "Some Internal ERROR might have occurred", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void openIntent() {
        intent.putExtra("subject", subName);
        intent.putExtra("teacher", teacherName);
        startActivity(intent);
    }

    private void inttilizingValueAndVariables(View v) {
        sun_1st = v.findViewById(R.id.sun_1st);     sun_1st_code = sun_1st.getText().toString().trim();
        sun_2nd = v.findViewById(R.id.sun_2nd);     sun_2nd_code = sun_2nd.getText().toString().trim();
        sun_3rd = v.findViewById(R.id.sun_3rd);     sun_3rd_code = sun_3rd.getText().toString().trim();
        sun_4th = v.findViewById(R.id.sun_4th);     sun_4th_code = sun_4th.getText().toString().trim();
        sun_5th = v.findViewById(R.id.sun_5th);     sun_5th_code = sun_5th.getText().toString().trim();

        mon_1st = v.findViewById(R.id.mon_1st);     mon_1st_code = mon_1st.getText().toString().trim();
        mon_2nd = v.findViewById(R.id.mon_2nd);     mon_2nd_code = mon_2nd.getText().toString().trim();
        mon_3rd = v.findViewById(R.id.mon_3rd);     mon_3rd_code = mon_3rd.getText().toString().trim();
        mon_4th = v.findViewById(R.id.mon_4th);     mon_4th_code = mon_4th.getText().toString().trim();

        tue_1st = v.findViewById(R.id.tue_1st);     tue_1st_code= tue_1st.getText().toString().trim();
        tue_2nd = v.findViewById(R.id.tue_2nd);     tue_2nd_code = tue_2nd.getText().toString().trim();

        wed_1st = v.findViewById(R.id.wed_1st);     wed_1st_code = wed_1st.getText().toString().trim();
        wed_2nd = v.findViewById(R.id.wed_2nd);     wed_2nd_code = wed_2nd.getText().toString().trim();
        wed_3rd = v.findViewById(R.id.wed_3rd);     wed_3rd_code = wed_3rd.getText().toString().trim();
        wed_4th = v.findViewById(R.id.wed_4th);     wed_4th_code = wed_4th.getText().toString().trim();

        thu_1st = v.findViewById(R.id.thu_1st);     thu_1st_code = thu_1st.getText().toString().trim();
        thu_2nd = v.findViewById(R.id.thu_2nd);     thu_2nd_code = thu_2nd.getText().toString().trim();
        thu_3rd = v.findViewById(R.id.thu_3rd);     thu_3rd_code = thu_3rd.getText().toString().trim();
        thu_4th = v.findViewById(R.id.thr_4th);     thu_4th_code = thu_4th.getText().toString().trim();
        thu_5th= v.findViewById(R.id.thr_5th);      thu_5th_code = thu_5th.getText().toString().trim();
        thu_6th = v.findViewById(R.id.thr_6th);     thu_6th_code = thu_6th.getText().toString().trim();
        tea_break = v.findViewById(R.id.tea_break);  tea_break_name = tea_break.getText().toString().trim();
    }
}
