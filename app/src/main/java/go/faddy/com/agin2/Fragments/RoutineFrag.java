package go.faddy.com.agin2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import go.faddy.com.agin2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoutineFrag extends Fragment {
    Button good;

    public RoutineFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_routine, container, false);
        v.findViewById(R.id.good).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext() , "very good", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
